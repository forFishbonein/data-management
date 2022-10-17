package com.imis.datamanagement.controller;
/*
 *
 * @Time : 2022/10/9
 * @Author : https://blog.csdn.net/m0_56170277
 * @File : DataManagement4IMIS
 */

import com.imis.datamanagement.common.result.Result;
import com.imis.datamanagement.common.vo.LoginVo;
import com.imis.datamanagement.common.vo.RegisterVo;
import com.imis.datamanagement.common.vo.TeacherRegisterVo;
import com.imis.datamanagement.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/t")
@Slf4j
public class TeacherController {

    @Resource
    TeacherService teacherService;

    @PostMapping("/login")
    public Result<String> codeLogin(HttpServletResponse response, @RequestBody LoginVo loginVo) {
        teacherService.codeLogin(response, loginVo);
        return Result.success("登陆成功");
    }

    @PostMapping("/passLogin")
    public Result<String> passLogin(HttpServletResponse response, @RequestBody LoginVo loginVo) {
        teacherService.passLogin(response, loginVo);
        return Result.success("登陆成功");
    }

    @PostMapping("/register")
    public Result<String> register(HttpServletResponse response, @RequestBody TeacherRegisterVo registerVo) {
        teacherService.register(response, registerVo);
        return Result.success("注册成功");
    }
}
