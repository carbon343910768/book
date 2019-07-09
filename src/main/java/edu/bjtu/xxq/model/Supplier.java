package edu.bjtu.xxq.model;

public class Supplier {

    private String registerNo;
    private String company;
    private String phone;
    private String email;

    public String getRegisterNo() {
        return registerNo;
    }

    public Supplier setRegisterNo(String registerNo) {
        this.registerNo = registerNo;
        return this;
    }

    public String getCompany() {
        return company;
    }

    public Supplier setCompany(String company) {
        this.company = company;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Supplier setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Supplier setEmail(String email) {
        this.email = email;
        return this;
    }
}
