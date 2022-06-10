package com.sun.study5_utils.config.error;

/**
 * 密码错误异常
 */
public class PasswordException extends BaseException {
    public PasswordException() {
        super(10001, "密码错误");
    }
}
