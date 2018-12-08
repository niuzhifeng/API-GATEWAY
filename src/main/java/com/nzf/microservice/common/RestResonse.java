package com.nzf.microservice.common;

public class RestResonse<T> {

    private int code;
    private String msg;
    private T result;

    public static <T> RestResonse<T> success(){
        return new  RestResonse();
    }

    public static <T> RestResonse<T> success(T result){
        RestResonse restResonse = new  RestResonse();
        restResonse.setResult(result);
        return restResonse;
    }

    public RestResonse(){
        this(RestCode.OK.getCode(),RestCode.OK.getMsg());
    }

    public RestResonse(int code,String msg){
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

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
