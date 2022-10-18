package com.imis.datamanagement.redis.utils;
/*
 *
 * @Time : 2022/10/10
 * @Author : https://blog.csdn.net/m0_56170277
 * @File : DataManagement4IMIS
 */

import java.util.UUID;

public class UUIDUtil {
    public static String uuid() {
        //生成一个随机的UUID作为token，例如：c836bd4b95994ec0a3e266c12f521f96
        return UUID.randomUUID().toString().replace("-", "");
    }

}
