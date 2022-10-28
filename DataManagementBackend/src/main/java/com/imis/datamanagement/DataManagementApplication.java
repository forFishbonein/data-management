package com.imis.datamanagement;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.jmx.support.RegistrationPolicy;


@SpringBootApplication
@ServletComponentScan
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
@Slf4j
public class DataManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataManagementApplication.class, args);
        log.info("--------------------我们启动成功啦！--------------------");



    }
}
