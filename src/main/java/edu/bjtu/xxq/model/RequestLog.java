package edu.bjtu.xxq.model;

public class RequestLog {

    private String date;
    private String time;
    private String ip;
    private String uri;
    private String header;
    private String body;
    private Integer userId;

    public String getDate() {
        return date;
    }

    public RequestLog setDate(String date) {
        this.date = date;
        return this;
    }

    public String getTime() {
        return time;
    }

    public RequestLog setTime(String time) {
        this.time = time;
        return this;
    }

    public String getIp() {
        return ip;
    }

    public RequestLog setIp(String ip) {
        this.ip = ip;
        return this;
    }

    public String getUri() {
        return uri;
    }

    public RequestLog setUri(String uri) {
        this.uri = uri;
        return this;
    }

    public String getHeader() {
        return header;
    }

    public RequestLog setHeader(String header) {
        this.header = header;
        return this;
    }

    public String getBody() {
        return body;
    }

    public RequestLog setBody(String body) {
        this.body = body;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public RequestLog setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }
}
