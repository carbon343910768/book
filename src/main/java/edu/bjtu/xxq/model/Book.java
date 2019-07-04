package edu.bjtu.xxq.model;
/*
书籍的实体类
 */
public class Book {
    private String bookId;
    private String bookName;
    private String bookContent;
    private String bookAuthor ;
    private String bookPublisher  ;
    private String bookPublished ;
    private int bookPages ;
    private String bookISBN ;
    private String[] booktag;
    private int bookPrice;
    public Book(){

    }
    public Book(String bookId,String bookName){
        this.bookId = bookId;
        this.bookName = bookName;
    }

    public String getBookId() {
        return bookId;
    }
}
