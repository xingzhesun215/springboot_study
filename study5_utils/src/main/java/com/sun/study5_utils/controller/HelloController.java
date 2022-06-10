package com.sun.study5_utils.controller;

import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Log
@Controller
public class HelloController {


    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {

        log.warning("hello debug");
        log.info("hello info");
        return "Hello Springboot!!!   hello";
    }

}
