package com.imis.datamanagement.service;
/*
 *
 * @Time : 2022/10/10
 * @Author : https://blog.csdn.net/m0_56170277
 * @File : DataManagement4IMIS
 */

import com.imis.datamanagement.domain.User;

import java.util.Map;

public interface LoginService {

    String codeCheck(Map map);

    String passwordCheck(Map map);

    String register(User user);

    String logout(String token);

    String isRegistered(User user);

    String sendEmail(User user);

}
