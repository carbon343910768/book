package com.bjtuxxq.demo;
/*
用户类型的实体类
 */
public class User {
    private String id;//账号
    private String name;//用户名
    private String password;//密码
    private String context;//简介
    private String type;//用户类型
    public User(String id,String name,String password,String context, String type){
        this.context=context;
        this.id = id;
        this.name = name;
        this.password = password;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getContext() {
        return context;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getType() {
        return type;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setType(String type) {
        this.type = type;
    }
}
