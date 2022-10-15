package com.imis.datamanagement.utils;
/*
 *
 * @Time : 2022/10/15
 * @Author : https://blog.csdn.net/m0_56170277
 * @File : DataManagement4IMIS
 */

import java.lang.reflect.Field;

public class outprint {

    public static void outprint(String s1, Object o) {
        try {
            Class c = Class.forName(s1);
            Field[] fields = c.getDeclaredFields();
            for (Field f : fields) {
                f.setAccessible(true);
            }
            for (Field f : fields) {
                String field = f.toString().substring(f.toString().lastIndexOf(".") + 1);
                System.out.println(field + " ->>\t" + f.get(o));
            }
        } catch (ClassNotFoundException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
