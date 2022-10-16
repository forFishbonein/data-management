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
import com.imis.datamanagement.domain.Teacher;
import com.imis.datamanagement.domain.TeacherInfo;
import com.imis.datamanagement.exception.GlobalException;
import com.imis.datamanagement.mapper.TeacherInfoMapper;
import com.imis.datamanagement.mapper.TeacherMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TeacherInfoService extends ServiceImpl<TeacherInfoMapper, TeacherInfo> {

    @Resource
    TeacherInfoMapper teacherInfoMapper;

    @Resource
    TeacherService teacherService;

    public void createInfo(Long id) {
        Teacher teacherInMysql = teacherService.getById(id);
        if (teacherInMysql != null) {
            throw new GlobalException(CodeMsg.TEACHER_NOT_EXIST);
        }
        QueryWrapper<TeacherInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(TeacherInfo::getTeacherId, id);
        TeacherInfo teacherInfoInMysql = teacherInfoMapper.selectOne(queryWrapper);
        if (teacherInfoInMysql != null) {
            return;
        }
        TeacherInfo teacherInfo = new TeacherInfo();
        teacherInfo.setTeacherId(id);
        teacherInfoMapper.insert(teacherInfo);
    }

    public void updateInfo(TeacherInfo teacherInfo) {
        Teacher teacherInMysql = teacherService.getById(teacherInfo.getTeacherId());
        if (teacherInMysql == null) {
            throw new GlobalException(CodeMsg.TEACHER_NOT_EXIST);
        }
        QueryWrapper<TeacherInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(TeacherInfo::getTeacherId, teacherInfo.getTeacherId());
        TeacherInfo teacherInfoInMysql = teacherInfoMapper.selectOne(queryWrapper);
        if (teacherInfoInMysql == null) {
            throw new GlobalException(CodeMsg.TEACHER_NOT_EXIST);
        }
        teacherInfoMapper.update(teacherInfo, queryWrapper);
    }

}
