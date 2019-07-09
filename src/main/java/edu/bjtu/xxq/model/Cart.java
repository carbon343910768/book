package edu.bjtu.xxq.model;

public class Cart {
    private int id;
    private int owner;
    private String address;
    private String phone;

    public int getId() {
        return id;
    }

    public Cart setId(int id) {
        this.id = id;
        return this;
    }

    public int getOwner() {
        return owner;
    }

    public Cart setOwner(int owner) {
        this.owner = owner;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Cart setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Cart setPhone(String phone) {
        this.phone = phone;
        return this;
    }
}
