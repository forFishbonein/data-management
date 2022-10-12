/*
 * @Time : 2022/8/10 14:05
 * @Author : hao
 * @File : HttpContextUtils.java
 * @Software : IntelliJ IDEA
 */
package com.imis.datamanagement.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class HttpContextUtils {
    public static HttpServletRequest getHttpServletRequest(){

        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }
}
