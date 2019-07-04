package edu.bjtu.xxq.model;

import java.util.Date;

public class SysLog {
    private String ip;
    private String url;
    private String HTTPMethod;
    private String classMethod;
    private String result;

    public void setClassMethod(String classMethod) {
        this.classMethod = classMethod;
    }

    public void setHTTPMethod(String HTTPMethod) {
        this.HTTPMethod = HTTPMethod;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
