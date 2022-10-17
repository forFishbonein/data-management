package com.imis.datamanagement.service.impl;
/*
 *
 * @Time : 2022/10/16
 * @Author : https://blog.csdn.net/m0_56170277
 * @File : DataManagement4IMIS
 */

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imis.datamanagement.common.result.CodeMsg;
import com.imis.datamanagement.common.vo.LoginVo;
import com.imis.datamanagement.common.vo.RegisterVo;
import com.imis.datamanagement.common.vo.ShowVo;
import com.imis.datamanagement.common.vo.TeacherRegisterVo;
import com.imis.datamanagement.domain.Teacher;
import com.imis.datamanagement.domain.TeacherInfo;
import com.imis.datamanagement.exception.GlobalException;
import com.imis.datamanagement.mapper.TeacherMapper;
import com.imis.datamanagement.redis.CodeKey;
import com.imis.datamanagement.redis.RedisService;
import com.imis.datamanagement.redis.TeacherKey;
import com.imis.datamanagement.service.EmailService;
import com.imis.datamanagement.service.TeacherService;
import com.imis.datamanagement.service.UserService;
import com.imis.datamanagement.utils.UUIDUtil;
import com.imis.datamanagement.utils.ValidateCodeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Service
@Slf4j
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {

    @Resource
    TeacherMapper teacherMapper;

    @Resource
    EmailService emailService;

    @Resource
    RedisService redisService;

    public static final String COOKIE_NAME_TOKEN = "token";

    public Teacher getById(long id) {
        Teacher teacher = redisService.get(TeacherKey.getById, "" + id, Teacher.class);
        if (teacher != null) {
            return teacher;
        }
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Teacher::getTeacherId, id);
        teacher = teacherMapper.selectOne(queryWrapper);
        if (teacher != null) {
            redisService.set(TeacherKey.getById, "" + id, teacher);
        }
        return teacher;
    }

    @Override
    public Long getIdByEmail(String email) {
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Teacher::getTeacherEmail, email);
        Teacher teacher = teacherMapper.selectOne(queryWrapper);
        return teacher.getTeacherId();
    }

    public void sendEmail(LoginVo loginVo) {

        String email = loginVo.getEmail();
        if (email == null) {
            throw new GlobalException(CodeMsg.EMAIL_EMPTY);
        }
        if (redisService.exists(CodeKey.code, email)) {
            redisService.delete(CodeKey.code, email);
        }
        String subject = "邮件注册验证码";
        String code = ValidateCodeUtils.generateValidateCode(6).toString();
        log.warn("验证码已生成：" + code);
        String context = "验证码300s内有效，若重复发送验证码，请使用最新收到的验证码：" + code;
        emailService.sendEmailTemplate(email, subject, context);
        redisService.set(CodeKey.code, email, code);
        log.info("验证码发送成功");
    }

    @Override
    public String logout(String token) {
        return null;
    }

    @Override
    public String registered(Teacher teacher) {
        return null;
    }

    @Override
    public ShowVo show(Long id) {
        ShowVo showVo = teacherMapper.getByTeacherId(id);
        if (showVo == null) {
            throw new GlobalException(CodeMsg.USER_NOT_EXIST);
        }
        if (showVo != null) {
            redisService.set(TeacherKey.getById, "" + id, showVo);
        }
        return showVo;
    }

    public String codeLogin(HttpServletResponse response, LoginVo loginVo) {
        if (loginVo == null) {
            throw new GlobalException(CodeMsg.SERVER_ERROR);
        }
        String email = loginVo.getEmail();
        String code = loginVo.getCode();
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Teacher::getTeacherEmail, email);
        Teacher teacherInMysql = getOne(queryWrapper);
        if (teacherInMysql == null) {
            throw new GlobalException(CodeMsg.EMAIL_NOT_EXIST);
        }
        String codeInRedis = redisService.get(CodeKey.code, email, String.class);
        if (codeInRedis == null || !codeInRedis.equals(code)) {
            throw new GlobalException(CodeMsg.CODE_ERROR);
        }
        redisService.delete(CodeKey.code, email);
        String token = UUIDUtil.uuid();
        ShowVo teacher = show(teacherInMysql.getTeacherId());
        addCookie(response, token, teacher);
        return token;
    }

    @Override
    public void register(HttpServletResponse response, TeacherRegisterVo registerVo) {
        if (registerVo == null) {
            throw new GlobalException(CodeMsg.SERVER_ERROR);
        }
        String email = registerVo.getTeacherEmail();
        String code = registerVo.getCode();
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Teacher::getTeacherEmail, email);
        Teacher teacherInMysql = getOne(queryWrapper);
        if (teacherInMysql != null) {
            throw new GlobalException(CodeMsg.EMAIL_EXIST);
        }
        String codeInRedis = redisService.get(CodeKey.code, email, String.class);
        if (codeInRedis == null || !codeInRedis.equals(code)) {
            throw new GlobalException(CodeMsg.CODE_ERROR);
        }
        redisService.delete(CodeKey.code, email);
        Teacher teacher = new Teacher();
        teacher.setTeacherEmail(registerVo.getTeacherEmail());
        teacher.setTeacherPass(registerVo.getTeacherPass());

        teacherMapper.insert(teacher);
    }

    public void addCookie(HttpServletResponse response, String token, ShowVo teacher) {
        redisService.set(TeacherKey.token, token, teacher);
        Cookie cookie = new Cookie(COOKIE_NAME_TOKEN, token);
        cookie.setMaxAge(TeacherKey.token.expireSeconds());
        cookie.setPath("/");//设置为网站根目录
        response.addCookie(cookie);
    }

    public ShowVo getByToken(HttpServletResponse response, String token) {
        if (StringUtils.isEmpty(token)) {
            return null;
        }
        ShowVo teacher = redisService.get(TeacherKey.token, token, ShowVo.class);
        if (teacher != null) {
            addCookie(response, token, teacher);
        }
        return teacher;
    }

    public String passLogin(HttpServletResponse response, LoginVo loginVo) {
        if (loginVo == null) {
            throw new GlobalException(CodeMsg.SERVER_ERROR);
        }
        String email = loginVo.getEmail();
        String password = loginVo.getPassword();
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Teacher::getTeacherEmail, email);
        Teacher teacherInMysql = getOne(queryWrapper);
        if (teacherInMysql != null) {
            throw new GlobalException(CodeMsg.EMAIL_EXIST);
        }
        String passInMysql = teacherInMysql.getTeacherPass();
        if (!passInMysql.equals(password)) {
            throw new GlobalException(CodeMsg.PASSWORD_ERROR);
        }
        String token = UUIDUtil.uuid();
        ShowVo teacher = show(teacherInMysql.getTeacherId());
        addCookie(response, token, teacher);
        return token;
    }


}
