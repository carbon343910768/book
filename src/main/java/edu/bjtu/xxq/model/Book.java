package edu.bjtu.xxq.model;
/*
书籍的实体类
 */
public class Book {
    private int bookId;
    private String bookName;
    private String bookContent;
    private String bookAuthor ;
    private String bookPublisher  ;
    private String bookPublished ;
    private String bookISBN ;
    private String[] booktag;
    private float bookPrice;
    private int bookNum;
    public Book(){

    }
    public Book(int bookId,int bookNumber){
        this.bookId = bookId;
        this.bookNum = bookNumber;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookContent() {
        return bookContent;
    }

    public void setBookContent(String bookContent) {
        this.bookContent = bookContent;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookPublisher() {
        return bookPublisher;
    }

    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher;
    }

    public String getBookPublished() {
        return bookPublished;
    }

    public void setBookPublished(String bookPublished) {
        this.bookPublished = bookPublished;
    }

    public String getBookISBN() {
        return bookISBN;
    }

    public void setBookISBN(String bookISBN) {
        this.bookISBN = bookISBN;
    }

    public String[] getBooktag() {
        return booktag;
    }

    public void setBooktag(String[] booktag) {
        this.booktag = booktag;
    }

    public float getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(float bookPrice) {
        this.bookPrice = bookPrice;
    }

    public int getBookNum() {
        return bookNum;
    }

    public void setBookNum(int bookNum) {
        this.bookNum = bookNum;
    }
}
