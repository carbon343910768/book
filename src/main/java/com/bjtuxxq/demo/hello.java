package com.bjtuxxq.demo;

public class hello {
    private final long id;
    private final String content;
    public hello(long id ,String content){
        this.content = content;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
