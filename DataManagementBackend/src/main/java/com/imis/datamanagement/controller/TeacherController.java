package com.imis.datamanagement.controller;
/*
 *
 * @Time : 2022/10/9
 * @Author : https://blog.csdn.net/m0_56170277
 * @File : DataManagement4IMIS
 */

import com.imis.datamanagement.common.result.Result;
import com.imis.datamanagement.common.vo.LoginVo;
import com.imis.datamanagement.common.vo.ShowVo;
import com.imis.datamanagement.common.vo.TeacherRegisterVo;
import com.imis.datamanagement.service.TeacherInfoService;
import com.imis.datamanagement.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/t")
@Slf4j
public class TeacherController {

    final TeacherService teacherService;

    final TeacherInfoService teacherInfoService;

    public TeacherController(TeacherService teacherService, TeacherInfoService teacherInfoService) {
        this.teacherService = teacherService;
        this.teacherInfoService = teacherInfoService;
    }

    @PostMapping("/login")
    public Result<String> codeLogin(HttpServletResponse response, @RequestBody LoginVo loginVo) {
        return Result.success(teacherService.codeLogin(response, loginVo));
    }

    @PostMapping("/logout")
    public Result<String> logout(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        return Result.success(teacherService.logout(token));
    }

    @PostMapping("/passLogin")
    public Result<String> passLogin(HttpServletResponse response, @RequestBody LoginVo loginVo) {
        return Result.success(teacherService.passLogin(response, loginVo));
    }

    @PostMapping("/register")
    public Result<String> register(HttpServletResponse response, @RequestBody TeacherRegisterVo registerVo) {
        teacherService.register(response, registerVo);
        teacherInfoService.createInfo(teacherService.getIdByEmail(registerVo.getTeacherEmail()), registerVo);
        return Result.success("注册成功");
    }

    @GetMapping("/{id}")
    public Result<ShowVo> getById(@PathVariable("id") String id) {
        return Result.success(teacherService.show(id));
    }

    @GetMapping()
    public Result<List<ShowVo>> getAll() {
        return Result.success(teacherService.getAll());
    }

    @GetMapping("/user")
    public Result<ShowVo> getByToken(HttpServletRequest request, HttpServletResponse response) {
        String token = request.getHeader("Authorization");
        return Result.success(teacherService.getByToken(response, token));
    }

}
