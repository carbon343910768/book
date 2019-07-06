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

    public int getBookNum() {
        return bookNum;
    }
}
