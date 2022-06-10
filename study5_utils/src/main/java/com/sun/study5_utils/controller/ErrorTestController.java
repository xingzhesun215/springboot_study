package com.sun.study5_utils.controller;

import com.sun.study5_utils.config.error.PasswordException;
import com.sun.study5_utils.config.error.ResultDo;
import com.sun.study5_utils.config.error.VerificationCodeException;
import com.sun.study5_utils.dao.GoodsDao;
import com.sun.study5_utils.domain.GoodsDo;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Log
@RestController()
@RequestMapping("/error")
public class ErrorTestController {

    @Autowired
    private GoodsDao goodsDao;


    @ResponseBody
    @RequestMapping("/hello")
    public String jhello(){

        int a = 1 / 0;
        return "Hello Springboot!!!   hello";
    }

    @ResponseBody
    @RequestMapping("/success")
    public ResultDo hello() {
        GoodsDo goods = goodsDao.getById(1010L);
        ResultDo result = new ResultDo(goods);
        return result;
    }

    @ResponseBody
    @RequestMapping("/pswd")
    public ResultDo pswd() throws PasswordException {
        if (true) {
            log.warning("throw password exception");
            throw new PasswordException();
        }
        ResultDo result = new ResultDo(new PasswordException());
        return result;
    }

    @ResponseBody
    @RequestMapping("/verification")
    public ResultDo verification() throws VerificationCodeException {
        if (true) {
            log.warning("throw VerificationCodeException");
            throw new VerificationCodeException();
        }
        ResultDo result = new ResultDo(new VerificationCodeException());
        return result;
    }
}
