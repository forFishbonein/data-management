package com.imis.datamanagement.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.imis.datamanagement.common.vo.LoginVo;
import com.imis.datamanagement.common.vo.RegisterVo;
import com.imis.datamanagement.domain.User;

import javax.servlet.http.HttpServletResponse;

public interface UserService extends IService<User> {

    User getById(long id);

    String codeLogin(HttpServletResponse response, LoginVo loginVo);

    String passLogin(HttpServletResponse response, LoginVo loginVo);

    void addCookie(HttpServletResponse response, String token, User user);

    User getByToken(HttpServletResponse response, String token);

    void sendEmail(LoginVo loginVo);

    void register(HttpServletResponse response, RegisterVo registerVo);

    String logout(String token);

    String registered(User user);
}
