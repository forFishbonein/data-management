package com.imis.datamanagement.service;
/*
 *
 * @Time : 2022/10/16
 * @Author : https://blog.csdn.net/m0_56170277
 * @File : DataManagement4IMIS
 */

import com.imis.datamanagement.common.vo.LoginVo;
import com.imis.datamanagement.common.vo.RegisterVo;
import com.imis.datamanagement.domain.Teacher;

import javax.servlet.http.HttpServletResponse;

public interface TeacherService {

    Teacher getById(long id);

    String codeLogin(HttpServletResponse response, LoginVo loginVo);

    String passLogin(HttpServletResponse response, LoginVo loginVo);

    void addCookie(HttpServletResponse response, String token, Teacher teacher);

    Teacher getByToken(HttpServletResponse response, String token);

    void sendEmail(LoginVo loginVo);

    void register(HttpServletResponse response, RegisterVo registerVo);

    String logout(String token);

    String registered(Teacher teacher);
}
