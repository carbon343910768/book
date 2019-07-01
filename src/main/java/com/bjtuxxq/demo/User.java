package com.bjtuxxq.demo;


public class User {
    private int id;
    private String name;
    private String password;
    private String context;
    public User(int id,String name,String password,String context){
        this.context=context;
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public int getId() {
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

    public void setContext(String context) {
        this.context = context;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
