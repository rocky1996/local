package com.acat.enums;

/**
 * Created by IntelliJ IDEA.
 * User: wujinfan
 * Date: 2019-11-04
 */
public enum ResponseCode {

    SUCCESS(0,"操作成功"),
    ERROR_1(1,"参数为空"),
    ERROR_500(2,"第三方系统异常"),;

    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    ResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
