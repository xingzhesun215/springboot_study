package com.sun.study5_utils.config.error;

import lombok.Getter;
import lombok.Setter;

/**
 * 自定义异常
 */
@Getter
@Setter
public class BaseException extends Exception {
    /**
     * 错误码
     */
    private int code;
    /**
     * 错误提示信息
     */
    private String msg;

    public BaseException(int code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }
}
