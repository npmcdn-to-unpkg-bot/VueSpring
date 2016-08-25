package com.app.model;

import com.app.constant.Constant;

/**
 * Created by Jerry on 2016/8/25.
 * 响应类
 */
public class Response {

    private Integer code;
    private Object message;

    public Response(Integer code){
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

    public static Response SUCCESS = new Response(Constant.SUCCESS_CODE);
    public static Response FAILD = new Response(Constant.FAILD_CODE);

    public static Response SUCCESS(Object message){
        Response resp = Response.SUCCESS;
        resp.setMessage(message);
        return resp;
    }

    public static Response FAILD(Object message){
        Response resp = Response.FAILD;
        resp.setMessage(message);
        return resp;
    }
}
