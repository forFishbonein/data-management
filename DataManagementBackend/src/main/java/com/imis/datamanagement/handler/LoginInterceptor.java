//package com.imis.datamanagement.handler;
///*
// *
// * @Time : 2022/10/16
// * @Author : https://blog.csdn.net/m0_56170277
// * @File : DataManagement4IMIS
// */
//
//import com.alibaba.fastjson.JSON;
//import com.baomidou.mybatisplus.core.toolkit.StringUtils;
//import com.baomidou.mybatisplus.extension.api.R;
//import com.imis.datamanagement.common.result.Result;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.method.HandlerMethod;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@Component
//@Slf4j //lombok的方法
//public class LoginInterceptor implements HandlerInterceptor {
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//
//        if (!(handler instanceof HandlerMethod)){ //判断请求的类型是否为handlerMethod
//            return true; //如果不是，那么就直接放行，不拦截（因为请求的有可能是RequestResourceHandler，即resource下的static）
//        }
//        String token = request.getHeader("Authorization"); //从Header里面去拿token
//
//        //打印日志：
//        log.info("=================request start===========================");
//        String requestURI = request.getRequestURI();
//        log.info("request uri:{}", requestURI);
//        log.info("request method:{}", request.getMethod());
//        log.info("token:{}", token);
//        log.info("=================request end===========================");
//
//        if (StringUtils.isBlank(token)){ //如果token为空
//            R<String> result = Result.error("未登录");
//            response.setContentType("application/json;charset=utf-8"); //让浏览器识别我们返回的是一个json数据
//            response.getWriter().print(JSON.toJSONString(result)); //返回json信息
//            return false;
//        }
//        User user= loginService.checkToken(token); //认证token
//        if (user == null){ //如果认证失败
//            R<String> result = Result.error("未登录");
//            response.setContentType("application/json;charset=utf-8");
//            response.getWriter().print(JSON.toJSONString(result));
//            return false;
//        }
//        //登录验证成功，可以放行！
//
//        //否则就是登录状态，放行即可！
//        return true;
//    }
//
//}
