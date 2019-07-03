package com.bjtuxxq.demo.entity;

public class ShoppingCart {
    private String bookid;
    private int price;
    private int num;
    public ShoppingCart(){

    }
    public ShoppingCart(String bookid,int price,int num){
        this.bookid = bookid;
        this.price = price;
        this.num = num;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public int getPrice() {
        return price;
    }

    public String getBookid() {
        return bookid;
    }

    public static ShoppingCart merge(ShoppingCart s1, ShoppingCart s2) {
        if (!s1.equals(s2)) {
            throw new IllegalArgumentException();
        }
        return new ShoppingCart(s1.bookid, s1.price, s1.num + s2.num);
    }

    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + ((bookid == null) ? 0 : bookid.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ShoppingCart other = (ShoppingCart) obj;
        if (bookid == null) {
            if (other.bookid != null)
                return false;
        } else if (!bookid.equals(other.bookid))
            return false;
        return true;
    }
}
