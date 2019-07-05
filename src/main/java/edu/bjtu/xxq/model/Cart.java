package edu.bjtu.xxq.model;

public class Cart {
    private String bookId;
    private int price;
    private int num;

    public Cart() {

    }

    public Cart(String bookId, int price, int num) {
        this.bookId = bookId;
        this.price = price;
        this.num = num;
    }

    public Cart setBookId(String bookId) {
        this.bookId = bookId;
        return this;
    }

    public Cart setPrice(int price) {
        this.price = price;
        return this;
    }

    public Cart setNum(int num) {
        this.num = num;
        return this;
    }

    public static Cart merge(Cart s1, Cart s2) {
        if (!s1.equals(s2)) {
            throw new IllegalArgumentException();
        }
        return new Cart(s1.bookId, s1.price, s1.num + s2.num);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((bookId == null) ? 0 : bookId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cart other = (Cart) obj;
        if (bookId == null) {
            if (other.bookId != null)
                return false;
        } else if (!bookId.equals(other.bookId))
            return false;
        return true;
    }
}
