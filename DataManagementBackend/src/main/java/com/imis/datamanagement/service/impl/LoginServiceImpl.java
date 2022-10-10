package com.imis.datamanagement.service.impl;
/*
 *
 * @Time : 2022/10/10
 * @Author : https://blog.csdn.net/m0_56170277
 * @File : DataManagement4IMIS
 */

import com.alibaba.fastjson.JSON;
import com.imis.datamanagement.common.R;
import com.imis.datamanagement.domain.User;
import com.imis.datamanagement.service.LoginService;
import com.imis.datamanagement.service.UserService;
import com.imis.datamanagement.utils.JWTUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class LoginServiceImpl implements LoginService {


    @Override
    public String codeLogin(Map map) {
        return null;
    }

    @Override
    public String passLogin(Map map) {
        return null;
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

    @Override
    public String sendEmail(User user) {
        return null;
    }
}
