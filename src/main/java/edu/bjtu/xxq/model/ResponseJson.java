package edu.bjtu.xxq.model;


public class ResponseJson {

    private String message;
    private Object data;

    public ResponseJson(ResponseCode responseCode) {
        this.message = responseCode.getMessage();
    }

    public ResponseJson(ResponseCode responseCode, Object data) {
        this(responseCode);
        this.data = data;
    }
}
