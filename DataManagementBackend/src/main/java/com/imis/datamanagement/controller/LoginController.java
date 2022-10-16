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

    @PostMapping("/login")
    public Result<String> codeLogin(HttpServletResponse response, @RequestBody LoginVo loginVo) {
        userService.codeLogin(response, loginVo);
        return Result.success("登陆成功");
    }

    @PostMapping("/passLogin")
    public Result<String> passLogin(HttpServletResponse response, @RequestBody LoginVo loginVo) {
        userService.passLogin(response, loginVo);
        return Result.success("登陆成功");
    }

}
