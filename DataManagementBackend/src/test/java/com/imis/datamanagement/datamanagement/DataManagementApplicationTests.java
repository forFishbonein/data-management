package com.imis.datamanagement.datamanagement;

import com.imis.datamanagement.service.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;

@SpringBootTest
class DataManagementApplicationTests {

    @Autowired
    EmailService emailService;
    @Test
    void contextLoads() {
//        System.out.println("hello world");
        emailService.sendEmailTemplate("1111@qq.com","1111","1111");
    }

}
