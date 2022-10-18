package com.imis.datamanagement.service;
/*
 *
 * @Time : 2022/10/16
 * @Author : https://blog.csdn.net/m0_56170277
 * @File : DataManagement4IMIS
 */

import com.imis.datamanagement.common.vo.LoginVo;
import com.imis.datamanagement.common.vo.ShowVo;
import com.imis.datamanagement.common.vo.TeacherRegisterVo;
import com.imis.datamanagement.domain.Teacher;

import javax.servlet.http.HttpServletResponse;

public interface TeacherService {

    Teacher getById(long id);

    Long getIdByEmail(String email);

    String codeLogin(HttpServletResponse response, LoginVo loginVo);

    String passLogin(HttpServletResponse response, LoginVo loginVo);

    void addCookie(HttpServletResponse response, String token, ShowVo teacher);

    ShowVo getByToken(HttpServletResponse response, String token);

    void sendEmail(LoginVo loginVo);

    void register(HttpServletResponse response, TeacherRegisterVo registerVo);

    String logout(String token);

    String registered(Teacher teacher);

    ShowVo show(Long id);
}
