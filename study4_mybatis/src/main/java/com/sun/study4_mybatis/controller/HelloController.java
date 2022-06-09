package com.sun.study4_mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class HelloController {


    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "Hello Springboot!!!   hello";
    }


}
