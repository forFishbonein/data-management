package com.imis.datamanagement.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {


    @Override
    public void addCorsMappings(CorsRegistry registry) {

        //跨域配置：不可设置为*，不安全, 前后端分离项目，可能域名不一致（前端是8080，后端是8888）
        //注意我们用了nginx之后就不需要写端口号了：配置跨域，如果有多个域名就写多个
        registry.addMapping("/**")
                //是否发送cookie
                .allowCredentials(true)
                //放行哪些原始域
                .allowedOrigins("*")
                .allowedMethods(new String[]{"GET", "POST", "PUT", "DELETE"})
                .allowedHeaders("*")
                .exposedHeaders("*");
    }

//    //使拦截器生效：
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        //拦截test接口：后续实际遇到需要拦截的接口时，再配置为真正的拦截接口
//        //拦截/comments/create/change评论请求，因为评论是必须要登录的！
//        registry.addInterceptor(loginInterceptor)
//                .addPathPatterns("/test"); //拦截这个请求
////        registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns("/login/**").excludePathPatterns("/register")
////                .excludePathPatterns("/sendEmail");
//    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }

}
