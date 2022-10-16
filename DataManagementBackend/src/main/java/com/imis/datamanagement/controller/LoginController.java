package com.imis.datamanagement.controller;

import com.imis.datamanagement.common.result.Result;
import com.imis.datamanagement.common.vo.LoginVo;
import com.imis.datamanagement.common.vo.RegisterVo;
import com.imis.datamanagement.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping
@Slf4j
public class LoginController {

    @Resource
    UserService userService;

    @PostMapping("/register")
    public Result<String> register(HttpServletResponse response, @RequestBody RegisterVo registerVo) {
        userService.register(response, registerVo);
        return Result.success("注册成功");
    }

    @PostMapping("/login")
    public Result<String> login(HttpServletResponse response, @RequestBody LoginVo loginVo) {
        userService.codeLogin(response, loginVo);
        return Result.success("登陆成功");
    }

}
