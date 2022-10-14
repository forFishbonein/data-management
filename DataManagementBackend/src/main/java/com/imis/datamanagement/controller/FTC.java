package com.imis.datamanagement.controller;

import com.imis.datamanagement.domain.template.AbstractTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@Slf4j
public class FTC {


    @PostMapping("/test")
    public String test(@RequestBody AbstractTemplate abstractTemplate) {


        System.out.println(abstractTemplate);

        return "ok";
    }


}
