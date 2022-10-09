package com.sekc.datamanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@SpringBootApplication
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class DataManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataManagementApplication.class, args);
    }

}
