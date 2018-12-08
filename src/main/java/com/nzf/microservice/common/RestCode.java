package com.nzf.microservice.common;

public enum RestCode {
    
    OK(0,"OK"),
    UNKNOW_ERROR(9999,"未知错误"),
    PAGE_ERROR(10010,"分页错误"),
    ILLEGAL_ERROR(10011,"参数异常");

    private int code;
    private String msg;

    private RestCode(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

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
}
