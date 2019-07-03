package com.bjtuxxq.demo.model;


public class ResponseJson {

    private int code;
    private String msg;
    private Object data;

    public ResponseJson(RespCode respCode) {
        this.code = respCode.getCode();
        this.msg = respCode.getMsg();
    }

    public ResponseJson(RespCode respCode, Object data) {
        this(respCode);
        this.data = data;
    }
}
