package com.bjtuxxq.demo.entity;


public class Entity {
    private int code;
    private String msg;
    private Object data;
    public Entity(RespCode respCode) {
        this.code = respCode.getCode();
        this.msg = respCode.getMsg();
    }

    public Entity(RespCode respCode, Object data) {
        this(respCode);
        this.data = data;
    }
}
