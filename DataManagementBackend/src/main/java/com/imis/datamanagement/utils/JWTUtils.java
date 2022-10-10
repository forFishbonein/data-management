/*
 * @Time : 2022/8/30 17:11
 * @Author : hao
 * @File : JWTUtils.java
 * @Software : IntelliJ IDEA
 */
package com.imis.datamanagement.utils;

import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTUtils {

    private static final String jwtToken = "123456emall!@#$$"; //这个是密钥，即C部分

    public static String createToken(Long userId){ //建立token
        Map<String,Object> claims = new HashMap<>(); //这个用于存储B部分
        claims.put("userId",userId);
        JwtBuilder jwtBuilder = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, jwtToken) // 签发算法，秘钥为jwtToken
                .setClaims(claims) // body数据，要唯一，自行设置
                .setIssuedAt(new Date()) // 设置签发时间
                .setExpiration(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000));// 一天的有效时间
        String token = jwtBuilder.compact();
        return token;
    }

    public static Map<String, Object> checkToken(String token){ //解析token
        try {
            Jwt parse = Jwts.parser().setSigningKey(jwtToken).parse(token); //提供密钥来解析token
            return (Map<String, Object>) parse.getBody();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

// 测试：
//    public static void main(String[] args) {
//        String token = JWTUtils.createToken(100L);
//        System.out.println(token);
//        Map<String, Object> stringObjectMap = JWTUtils.checkToken(token);
//        System.out.println(stringObjectMap.get("userId"));
//    }

}


