package edu.bjtu.xxq.model;

public class Cart {
    private int cartId;
    private int cartOwner;
    private String address;

    public int getCartId() {
        return cartId;
    }

    public Cart setCartId(int cartId) {
        this.cartId = cartId;
        return this;
    }

    public int getCartOwner() {
        return cartOwner;
    }

    public Cart setCartOwner(int cartOwner) {
        this.cartOwner = cartOwner;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Cart setAddress(String address) {
        this.address = address;
        return this;
    }
}
