package edu.bjtu.xxq.model;

public class Supply {

    private int id;
    private String company;
    private String date;
    private String address;
    private Integer[] bookId;
    private Integer[] number;

    public int getId() {
        return id;
    }

    public Supply setId(int id) {
        this.id = id;
        return this;
    }

    public String getCompany() {
        return company;
    }

    public Supply setCompany(String company) {
        this.company = company;
        return this;
    }

    public String getDate() {
        return date;
    }

    public Supply setDate(String date) {
        this.date = date;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Supply setAddress(String address) {
        this.address = address;
        return this;
    }

    public Integer[] getBookId() {
        return bookId;
    }

    public Supply setBookId(Integer[] bookId) {
        this.bookId = bookId;
        return this;
    }

    public Integer[] getNumber() {
        return number;
    }

    public Supply setNumber(Integer[] number) {
        this.number = number;
        return this;
    }
}
