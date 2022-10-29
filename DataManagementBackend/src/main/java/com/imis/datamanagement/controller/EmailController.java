package com.imis.datamanagement.controller;

import com.imis.datamanagement.common.result.Result;
import com.imis.datamanagement.common.vo.LoginVo;
import com.imis.datamanagement.service.EmailService;
import com.imis.datamanagement.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;


import javax.annotation.Resource;

@RestController
@RequestMapping
@Slf4j
public class EmailController {

    @Resource
    UserService userService;
    @Resource
    EmailService emailService;

    @PostMapping("/sendEmail")
    public Result<String> sendMimeMail(@RequestBody LoginVo loginVo) {
        userService.sendEmail(loginVo);
        return Result.success("已发送");
    }
}
