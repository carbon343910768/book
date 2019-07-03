package com.bjtuxxq.demo.entity;

public enum RespCode {
    LOGINSUCCESS(0, "登录成功"),
    LOGINWARN_PASSWORD(-1, "登录失败，密码错误"),
    LOGINWARN_USERNAME_EMPTY(-2, "登录失败，用户名空"),
    LOGINWARN_USERNAME_EXIST(-3, "登录失败，用户名不存在"),
    REGISTSUCCESS(0, "注册成功"),
    REGISTWARN_PASSWORD(-1, "注册失败，密码错误"),
    REGISTWARN_USERNAME_EMPTY(-2, "注册失败，用户名空"),
    REGISTWARN_USERNAME_EXIST(-3, "注册失败，用户名存在"),
    SHOPPINGCART_ADD_SUCCESS(0,"购物车修改成功"),
    SHOPPINGCART_ADD_WARN(-1,"购物车修改失败"),
    BUYCART_SUCCESS(0,"购买勾选成功"),
    BUYCART_WARN(-1,"购买勾选失败"),
    ;

    private int code;
    private String msg;

    RespCode(int code, String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }
}
