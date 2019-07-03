package com.bjtuxxq.demo.entity;
/*
用户类型的实体类
 */
public class User {
    private String id;//账号
    private String name;//用户名
    private String password;//密码
    private String context;//简介
    private String type;//用户类型
    private String[] tag;
    public User(){ }
    public String getPasswordByUsername(String name){
        return password;
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

    public String[] getTag() {
        return tag;
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

    public void setTag(String[] tag) {
        this.tag = tag;
    }
}
