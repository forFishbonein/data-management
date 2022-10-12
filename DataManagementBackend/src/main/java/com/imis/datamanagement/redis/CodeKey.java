package com.imis.datamanagement.redis;
/*
 *
 * @Time : 2022/10/11
 * @Author : https://blog.csdn.net/m0_56170277
 * @File : DataManagement4IMIS
 */

public class CodeKey extends BasePrefix {

    //code存在时间
    //5分钟
    public static final int CODE_EXPIRE = 60*5;

    //缓存的前缀
    public static final String CODE_PREFIX = "code";


    public CodeKey(String prefix) {
        super(prefix);
    }

    public CodeKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    /**
     * 需要缓存的字段
     */
    public static CodeKey code = new CodeKey(CODE_EXPIRE, CODE_PREFIX);

}
