package edu.bjtu.xxq.model;

import java.util.List;

/*
书籍的实体类
 */
public class Book {

    private int bookId;
    private String bookName;
    private String bookDescription;
    private String bookAuthor;
    private String bookPublisher;
    private String bookPublished;
    private String bookISBN;
    private String bookPrice;

    public int getBookId() {
        return bookId;
    }

    public Book setBookId(int bookId) {
        this.bookId = bookId;
        return this;
    }

    public String getBookName() {
        return bookName;
    }

    public Book setBookName(String bookName) {
        this.bookName = bookName;
        return this;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public Book setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
        return this;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public Book setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
        return this;
    }

    public String getBookPublisher() {
        return bookPublisher;
    }

    public Book setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher;
        return this;
    }

    public String getBookPublished() {
        return bookPublished;
    }

    public Book setBookPublished(String bookPublished) {
        this.bookPublished = bookPublished;
        return this;
    }

    public String getBookISBN() {
        return bookISBN;
    }

    public Book setBookISBN(String bookISBN) {
        this.bookISBN = bookISBN;
        return this;
    }

    public String getBookPrice() {
        return bookPrice;
    }

    public Book setBookPrice(String bookPrice) {
        this.bookPrice = bookPrice;
        return this;
    }
}
