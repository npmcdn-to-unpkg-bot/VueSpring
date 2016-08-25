package com.app.model;

import com.app.constant.Constant;

/**
 * Created by Jerry on 2016/8/25.
 * 响应类
 */
public class HttpResponse {

    private Integer code;
    private Object message;

    public HttpResponse(Integer code){
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public static HttpResponse SUCCESS = new HttpResponse(Constant.SUCCESS_CODE);
    public static HttpResponse FAILD = new HttpResponse(Constant.FAILD_CODE);

    public static HttpResponse SUCCESS(Object message){
        HttpResponse resp = HttpResponse.SUCCESS;
        resp.setMessage(message);
        return resp;
    }

    public static HttpResponse FAILD(Object message){
        HttpResponse resp = HttpResponse.FAILD;
        resp.setMessage(message);
        return resp;
    }
}
