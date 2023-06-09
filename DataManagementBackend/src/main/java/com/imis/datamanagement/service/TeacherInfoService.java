package com.imis.datamanagement.service;
/*
 *
 * @Time : 2022/10/16
 * @Author : https://blog.csdn.net/m0_56170277
 * @File : DataManagement4IMIS
 */

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imis.datamanagement.common.result.CodeMsg;
import com.imis.datamanagement.common.vo.TeacherRegisterVo;
import com.imis.datamanagement.domain.Teacher;
import com.imis.datamanagement.domain.TeacherInfo;
import com.imis.datamanagement.exception.GlobalException;
import com.imis.datamanagement.mapper.TeacherInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TeacherInfoService extends ServiceImpl<TeacherInfoMapper, TeacherInfo> {

    final TeacherInfoMapper teacherInfoMapper;

    final TeacherService teacherService;

    public TeacherInfoService(TeacherInfoMapper teacherInfoMapper, TeacherService teacherService) {
        this.teacherInfoMapper = teacherInfoMapper;
        this.teacherService = teacherService;
    }

    public void createInfo(Long id, TeacherRegisterVo registerVo) {
        Teacher teacherInMysql = teacherService.getById(id);
        if (teacherInMysql == null) {
            throw new GlobalException(CodeMsg.USER_NOT_EXIST);
        }
        QueryWrapper<TeacherInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(TeacherInfo::getTeacherId, id);
        TeacherInfo teacherInfoInMysql = teacherInfoMapper.selectOne(queryWrapper);
        if (teacherInfoInMysql != null) {
            return;
        }
        TeacherInfo teacherInfo = new TeacherInfo();
        teacherInfo.setTeacherId(id);
        teacherInfo.setTeacherSid(registerVo.getTeacherSid());
        teacherInfo.setTeacherName(registerVo.getTeacherName());
        teacherInfo.setTeacherTele(registerVo.getTeacherTele());
        teacherInfo.setTeacherTitle(registerVo.getTeacherTittle());
        teacherInfoMapper.insert(teacherInfo);
    }

    public void updateInfo(TeacherInfo teacherInfo) {
        Teacher teacherInMysql = teacherService.getById(teacherInfo.getTeacherId());
        if (teacherInMysql == null) {
            throw new GlobalException(CodeMsg.USER_NOT_EXIST);
        }
        QueryWrapper<TeacherInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(TeacherInfo::getTeacherId, teacherInfo.getTeacherId());
        TeacherInfo teacherInfoInMysql = teacherInfoMapper.selectOne(queryWrapper);
        if (teacherInfoInMysql == null) {
            throw new GlobalException(CodeMsg.USER_NOT_EXIST);
        }
        teacherInfoMapper.update(teacherInfo, queryWrapper);
    }

}
