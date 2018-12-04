package com.beyond;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@MapperScan("com.beyond")
@SpringBootApplication
public class StApplication {

    public static void main(String[] args) {
        SpringApplication.run(StApplication.class, args);
    }
}
