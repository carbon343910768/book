package edu.bjtu.xxq.model;

public enum ResponseCode {

    LOGIN_SUCCESS("login success"),
    LOGIN_FAIL("login fail"),

    REGISTER_SUCCESS("register success"),
    REGISTER_FAIL("register fail"),
    REGISTER_ILLEGAL_PASSWORD("register illegal password"),
    REGISTER_ILLEGAL_USERNAME("register illegal username"),
    REGISTER_EXISTED_USERNAME("register illegal password"),

    ADD_TO_CART_SUCCESS("add to cart success"),
    ADD_TO_CART_FAIL("add to cart fail"),

    ORDER_SUCCESS("order success"),
    ORDER_FAIL( "order fail"),;

    private String message;

    ResponseCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
