package com.imis.datamanagement.service;
/*
 *
 * @Time : 2022/10/10
 * @Author : https://blog.csdn.net/m0_56170277
 * @File : DataManagement4IMIS
 */

import com.imis.datamanagement.domain.User;

public interface LoginService {

    String register(User user);

    String logout(String token);

    String registered(User user);

    //发送邮件验证码
    String sendEmail(User user);

}
