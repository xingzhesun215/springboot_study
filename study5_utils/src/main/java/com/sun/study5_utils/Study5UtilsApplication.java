package com.sun.study5_utils;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling // 开启定时任务
public class Study5UtilsApplication {

    public static void main(String[] args) {
        SpringApplication.run(Study5UtilsApplication.class, args);
    }

}
