package edu.bjtu.xxq.model;

/*
书籍的实体类
 */
public class Book {

    private int bookId;
    private String bookName;
    private String bookContent;
    private String bookAuthor;
    private String bookPublisher;
    private String bookPublished;
    private String bookISBN;
    private float bookPrice;
    private String[] bookTags;
    private int bookCoverImage;

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

    public String getBookContent() {
        return bookContent;
    }

    public Book setBookContent(String bookContent) {
        this.bookContent = bookContent;
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

    public float getBookPrice() {
        return bookPrice;
    }

    public Book setBookPrice(float bookPrice) {
        this.bookPrice = bookPrice;
        return this;
    }

    public String[] getBookTags() {
        return bookTags;
    }

    public Book setBookTags(String[] bookTags) {
        this.bookTags = bookTags;
        return this;
    }

    public int getBookCoverImage() {
        return bookCoverImage;
    }

    public Book setBookCoverImage(int bookCoverImage) {
        this.bookCoverImage = bookCoverImage;
        return this;
    }
}
