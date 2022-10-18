package com.imis.datamanagement.controller;

import com.imis.datamanagement.common.result.Result;
import com.imis.datamanagement.common.vo.RegisterVo;
import com.imis.datamanagement.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

@RestController
@Slf4j
public class RegisterController {
    @Resource
    UserService userService;

    @PostMapping("/register")
    public Result<String> register(HttpServletResponse response, @RequestBody RegisterVo registerVo) {
        userService.register(response, registerVo);
        return Result.success("注册成功");
    }
}
