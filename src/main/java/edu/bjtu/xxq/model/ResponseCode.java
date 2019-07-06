package edu.bjtu.xxq.model;

public enum ResponseCode {

    LOGIN_SUCCESS("login success"),
    LOGIN_FAIL("login fail"),

    REGISTER_SUCCESS("register success"),
    REGISTER_FAIL("register fail"),
    REGISTER_ILLEGAL_PASSWORD("register illegal password"),
    REGISTER_ILLEGAL_USERNAME("register illegal username"),
    REGISTER_EXISTED_USERNAME("register illegal password"),

    ADD_BOOK_SUCCESS("add book success"),
    ADD_BOOK_FAIL("add book fail"),
    ADD_TAG_SUCCESS("add tag success"),
    ADD_TAG_FAIL("add tag fail"),

    ADD_TO_CART_SUCCESS("add to cart success"),
    ADD_TO_CART_FAIL("add to cart fail"),

    ORDER_SUCCESS("order success"),
    ORDER_FAIL( "order fail"),

    LOAD_ALL_BOOK_SUCCESS("load all book success"),

    LOAD_ORDER_SUCCESS("load success"),
    LOAD_ORDER_WARN("load fail"),
    ADD_ORDER_SUCCESS("add order success");

    private String message;

    ResponseCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
