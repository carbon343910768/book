package edu.bjtu.xxq.model;

public class CustomerDetail {

    private int id;
    private String username;
    private String name;
    private String phone;
    private String email;

    public int getId() {
        return id;
    }

    public CustomerDetail setId(int id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public CustomerDetail setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getName() {
        return name;
    }

    public CustomerDetail setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public CustomerDetail setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CustomerDetail setEmail(String email) {
        this.email = email;
        return this;
    }
}
