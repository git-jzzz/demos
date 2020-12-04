package com.demos.musicmanager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.demos.musicmanager.mapper")
public class MusicManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MusicManagerApplication.class, args);
    }

}
