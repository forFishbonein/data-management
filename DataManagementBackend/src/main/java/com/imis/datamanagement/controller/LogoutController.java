package com.imis.datamanagement.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/logout")
public class LogoutController {

    @Resource
    TeacherService teacherService;

    @PostMapping
    public Result<String> logout(String token) {
        return Result.success(teacherService.logout(token));
    }



}