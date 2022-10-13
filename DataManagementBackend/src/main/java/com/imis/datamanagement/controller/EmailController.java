package com.imis.datamanagement.controller;

import com.imis.datamanagement.common.result.Result;
import com.imis.datamanagement.common.vo.LoginVo;
import com.imis.datamanagement.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.xml.ws.soap.Addressing;

@RestController
@RequestMapping
@Slf4j
public class EmailController {

    @Resource
    UserService userService;

    @PostMapping("/sendEmail")
    public Result<String> sendEmail(@RequestBody LoginVo loginVo){
        userService.sendEmail(loginVo);
        return Result.success("已发送");
    }
}
