package com.sun.study5_utils.config.error;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * Rest控制器异常处理类
 */
@RestControllerAdvice(annotations = RestController.class) // 全局异常处理
public class ExceptionConfig {
    /**
     * 处理BaseException类(及其子类)的异常
     */
    @ExceptionHandler({ BaseException.class })
    public ResultDo baseExceptionHandler(BaseException e) {
        return new ResultDo(e);
    }

    /**
     * 处理Exception类的异常
     */
    @ExceptionHandler({ Exception.class })
    public ResultDo exceptionHandler(Exception e) {
        return new ResultDo(e);
    }
}
