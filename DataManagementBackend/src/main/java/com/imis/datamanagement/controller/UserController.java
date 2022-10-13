package com.imis.datamanagement.controller;

import com.imis.datamanagement.common.result.CodeMsg;
import com.imis.datamanagement.common.result.Result;
import com.imis.datamanagement.common.vo.RegisterVo;
import com.imis.datamanagement.domain.User;
import com.imis.datamanagement.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Resource
    UserService userService;

    @GetMapping("/{id}")
    public Result<User> getByUserId(@PathVariable("id") Long userId){
        User user = userService.getById(userId);
        if (user == null) {
            return Result.error(CodeMsg.USER_NOT_EXIST);
        }
        return Result.success(user);
    }

    @PutMapping
    public Result<String> register(HttpServletResponse response, @RequestBody RegisterVo registerVo) {
        userService.register(response, registerVo);
        return Result.success("注册成功");
    }



}
