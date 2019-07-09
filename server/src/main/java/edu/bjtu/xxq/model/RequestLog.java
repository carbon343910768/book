package edu.bjtu.xxq.model;

import java.time.LocalDateTime;

public class RequestLog {

    private String date;
    private String time;
    private String ip;
    private String uri;
    private String header;
    private String body;
    private String userId;

    public String getDate() {
        return date;
    }

    public RequestLog setDateTime(LocalDateTime dateTime) {
        this.date = dateTime.toLocalDate().toString();
        this.time = dateTime.toLocalTime().toString();
        return this;
    }

    public String getTime() {
        return time;
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

    public String getUserId() {
        return userId;
    }

    public RequestLog setUserId(String userId) {
        this.userId = userId;
        return this;
    }
}
