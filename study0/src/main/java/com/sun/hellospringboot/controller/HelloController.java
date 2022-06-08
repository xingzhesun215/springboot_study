package com.sun.hellospringboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @Value("${myName}")
    private String name;

    @Value("${myAge}")
    private int age;

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "Hello Springboot!!!   hello" + name + "   " + age;
    }
}
