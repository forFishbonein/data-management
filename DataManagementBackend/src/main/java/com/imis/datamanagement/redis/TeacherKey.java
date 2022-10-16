package com.imis.datamanagement.redis;

public class TeacherKey extends BasePrefix {

    //token存在时间
    public static final int TOKEN_EXPIRE = 3600*24 *2;//默认两天

    //缓存的前缀
    public static final String TOKEN_PREFIX = "token";
    public static final String GET_BY_ID = "id";


    /**
     * 防止被外面实例化
     */
    private TeacherKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    /**
     * 需要缓存的字段
     */
    public static TeacherKey token = new TeacherKey(TOKEN_EXPIRE, TOKEN_PREFIX);
    //不设置存在时间则一直存储
    public static TeacherKey getById = new TeacherKey(0, GET_BY_ID);

}
