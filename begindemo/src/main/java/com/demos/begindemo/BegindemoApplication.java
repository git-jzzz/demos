package com.demos.begindemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.demos.begindemo.mapper")
public class BegindemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BegindemoApplication.class, args);
    }

}
