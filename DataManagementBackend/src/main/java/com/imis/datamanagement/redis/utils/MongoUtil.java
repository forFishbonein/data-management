package com.imis.datamanagement.redis.utils;
/*
 *
 * @Time : 2022/10/16
 * @Author : https://blog.csdn.net/m0_56170277
 * @File : DataManagement4IMIS
 */

import java.util.Random;

public class MongoUtil {

    public static Integer getMongoId() {
        Integer id = null;
        id = new Random().nextInt(999999);//生成随机数，最大为999999
        return id;
    }
}
