package com.bjtuxxq.demo.model;
/*
书籍的实体类
 */
public class Book {
    private String bookId;
    private String bookName;
    private String bookContext;
    private String bookPicture;
    private String[] booktag;
    private int bookPrice;
    public Book(){

    }

    public String getBookContext() {
        return bookContext;
    }

    public String getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public String getBookPicture() {
        return bookPicture;
    }

    public String[] getBooktag() {
        return booktag;
    }

    public int getBookPrice() {
        return bookPrice;
    }

    public void setBookContext(String bookContext) {
        this.bookContext = bookContext;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setBookPicture(String bookPicture) {
        this.bookPicture = bookPicture;
    }

    public void setBooktag(String[] booktag) {
        this.booktag = booktag;
    }

    public void setBookPrice(int bookPrice) {
        this.bookPrice = bookPrice;
    }
}
