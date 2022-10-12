package com.imis.datamanagement.controller;

import com.imis.datamanagement.common.result.CodeMsg;
import com.imis.datamanagement.common.result.Result;
import com.imis.datamanagement.domain.User;
import com.imis.datamanagement.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public Result<User> getByUserId(@PathVariable("id") Long userId){
        User user = userService.getById(userId);
        if (user == null) {
            return Result.error(CodeMsg.USER_NOT_EXIST);
        }
        return Result.success(user);
    }

}
