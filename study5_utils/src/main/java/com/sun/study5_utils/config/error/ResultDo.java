package com.sun.study5_utils.config.error;

import lombok.Getter;
import lombok.Setter;

/**
 * 后端接口返回的统一业务逻辑对象
 */
@Getter
@Setter
public class ResultDo<T> {

    /**
     * 错误码 0表示没有错误(异常) 其他数字代表具体错误码
     */
    private int code = 200;
    /**
     * 后端返回消息
     */
    private String msg = "success";
    /**
     * 后端返回的数据
     */
    private T data;

    /**
     * 无参数构造函数
     */
    public ResultDo() {
        this.code = 0;
        this.msg = "操作成功";
    }

    /**
     * 带数据data构造函数
     */
    public ResultDo(T data) {
        this();
        this.data = data;
    }

    /**
     * 存在异常的构造函数
     */
    public ResultDo(Exception ex) {
        if (ex instanceof BaseException) {
            this.code = ((BaseException) ex).getCode();
            this.msg = ex.getMessage();
            this.data = null;
        } else {
            this.code = -1;// 其他未定义异常
            this.msg = ex.getMessage();
            this.data = null;
        }
    }
}
