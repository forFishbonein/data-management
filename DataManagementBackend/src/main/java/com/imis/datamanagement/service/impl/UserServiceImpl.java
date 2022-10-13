package com.imis.datamanagement.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imis.datamanagement.common.result.CodeMsg;
import com.imis.datamanagement.common.vo.LoginVo;
import com.imis.datamanagement.domain.User;
import com.imis.datamanagement.exception.GlobalException;
import com.imis.datamanagement.mapper.UserMapper;
import com.imis.datamanagement.redis.CodeKey;
import com.imis.datamanagement.redis.RedisService;
import com.imis.datamanagement.redis.UserKey;
import com.imis.datamanagement.service.EmailService;
import com.imis.datamanagement.service.UserService;
import com.imis.datamanagement.utils.UUIDUtil;
import com.imis.datamanagement.utils.ValidateCodeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    EmailService emailService;

    @Autowired
    RedisService redisService;

    //cookie的名字
    public static final String COOKIE_NAME_TOKEN = "token";

    //不使用Spring Cache的注解，使用Jedis的方法以提升性能
    public User getById(long id) {
        //对象缓存
        //如果缓存中有，则直接取，如果没有，则从数据库查找
        User user = redisService.get(UserKey.getById, "" + id, User.class);
        if (user != null) {
            return user;
        }
        //取数据库
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(User::getUserId, id);
        user = userMapper.selectOne(queryWrapper);
        //再存入缓存
        if (user != null) {
            redisService.set(UserKey.getById, "" + id, user);
        }
        return user;
    }

    /**
     * TODO 验证码登录，发送验证码功能
     */
    public void sendEmail(LoginVo loginVo) {

        //获取用户邮箱
        String email = loginVo.getEmail();
        //用户邮箱不为空时，发送邮件
        if (email == null) {
            throw new GlobalException(CodeMsg.EMAIL_EMPTY);
        }
        //判断是否发送过验证码，若已经发送过验证码，则清除缓存的验证码
        if (redisService.exists(CodeKey.code, email)) {
            redisService.delete(CodeKey.code, email);
        }

        String subject = "邮件注册验证码";
        //生成验证码
        String code = ValidateCodeUtils.generateValidateCode(6).toString();
        log.warn("验证码已生成：" + code);
        String context = "验证码300s内有效，若重复发送验证码，请使用最新收到的验证码：" + code;
        //发送邮件
        emailService.sendEmailTemplate(email, subject, context);
        //将userEmail和code组成的key-value存入redis
        redisService.set(CodeKey.code, email, code);

        log.info("验证码发送成功");
    }

    @Override
    public String register(User user) {
        return null;
    }

    @Override
    public String logout(String token) {
        return null;
    }

    @Override
    public String registered(User user) {
        return null;
    }

    /*
     * TODO 登录校验
     * 分成两种login
     * 由于会对User邮箱进行判断，为了和Teacher类进行区分，登录的验证功能写在各Service内部
     */

    /**
     * 用户输入邮箱、验证码，选择验证码登录
     * @param response 用于存储cookie
     * @param loginVo
     * @return 返回token
     */
    public String codeLogin(HttpServletResponse response, LoginVo loginVo) {
        if (loginVo == null) {
            throw new GlobalException(CodeMsg.SERVER_ERROR);
        }
        //获取用户输入的邮箱和验证码
        String email = loginVo.getEmail();
        String code = loginVo.getCode();
        //取数据库,判断邮箱是否存在
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(User::getUserEmail, email);
        User user = getOne(queryWrapper);
        if (user == null) {
            throw new GlobalException(CodeMsg.EMAIL_NOT_EXIST);
        }
        //从Redis中获取缓存的验证码
        //TODO 类型暂时留空，需要从发送验证码那里看存储的什么类型，然后这里再填上
        String codeInRedis = redisService.get(CodeKey.code, email, String.class);
        //进行验证码的比对（页面提交的验证码和Redis中保存的验证码比对）
        if(codeInRedis == null || !codeInRedis.equals(code)){
            throw new GlobalException(CodeMsg.CODE_ERROR);
        }
        //如果校验成功，删除Redis中缓存的验证码
        redisService.delete(CodeKey.code, email);
        //生成唯一id作为token
        String token = UUIDUtil.uuid();
        //将token存入Cookie和redis
        addCookie(response, token, user);
        return token;
    }

    /**
     * 将token做为key，用户信息做为value 存入redis模拟session
     * 同时将token存入cookie，保存登录状态
     */
    public void addCookie(HttpServletResponse response, String token, User user) {
        redisService.set(UserKey.token, token, user);
        Cookie cookie = new Cookie(COOKIE_NAME_TOKEN, token);
        cookie.setMaxAge(UserKey.token.expireSeconds());
        cookie.setPath("/");//设置为网站根目录
        response.addCookie(cookie);
    }

    /**
     * 根据token获取用户信息
     */
    public User getByToken(HttpServletResponse response, String token) {
        if (StringUtils.isEmpty(token)) {
            return null;
        }
        User user = redisService.get(UserKey.token, token, User.class);
        //延长有效期，有效期等于最后一次操作+有效期
        if (user != null) {
            addCookie(response, token, user);
        }
        return user;
    }
}

//    public String passLogin(HttpServletResponse response, LoginVo loginVo) {
//        if (loginVo == null) {
//            throw new GlobalException(CodeMsg.SERVER_ERROR);
//        }
//        String email = loginVo.getEmail();
//        String formPass = loginVo.getPassword();
//        //判断手机号是否存在
//        User user = getById(Long.parseLong(mobile));
//        if (user == null) {
//            throw new GlobalException(CodeMsg.MOBILE_NOT_EXIST);
//        }
//        //验证密码
//        String dbPass = user.getPassword();
//        String saltDB = user.getSalt();
//        String calcPass = MD5Util.formPassToDBPass(formPass, saltDB);
//        if (!calcPass.equals(dbPass)) {
//            throw new GlobalException(CodeMsg.PASSWORD_ERROR);
//        }
//        //生成唯一id作为token
//        String token = UUIDUtil.uuid();
//        addCookie(response, token, user);
//        return token;
//    }


//    /**
//     * 典型缓存同步场景：更新密码
//     */
//    public boolean updatePassword(String token, long id, String formPass) {
//        //取user
//        User user = getById(id);
//        if(user == null) {
//            throw new GlobalException(CodeMsg.EMAIL_NOT_EXIST);
//        }
//        //更新数据库
//        User toBeUpdate = new User();
//        toBeUpdate.setId(id);
//        toBeUpdate.setPassword(MD5Util.formPassToDBPass(formPass, user.getSalt()));
//        userMapper.update(toBeUpdate);
//        //更新缓存：先删除再插入
//        redisService.delete(UserKey.getById, ""+id);
//        user.setPassword(toBeUpdate.getPassword());
//        redisService.set(UserKey.token, token, user);
//        return true;
//    }