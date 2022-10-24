package com.imis.datamanagement.controller;

import com.imis.datamanagement.common.result.Result;
import com.imis.datamanagement.service.TeacherService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


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