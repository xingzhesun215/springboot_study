package com.sun.study4_mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sun.study4_mybatis") // 指定MyBatis扫描的包，以便将数据访问接口注册为bean
public class Study4MybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(Study4MybatisApplication.class, args);
    }

}
