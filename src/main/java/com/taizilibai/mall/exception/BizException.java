package com.taizilibai.mall.exception;

/**
 * @Description:
 * @Author: zxx
 * @Date: 2020/8/20 11:32
 */
public class BizException extends RuntimeException{

    private String code;
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
