package edu.bjtu.xxq.model;

import java.util.List;

/*
书籍的实体类
 */
public class Book {

    private int id;
    private String name;
    private String description;
    private String author;
    private String publisher;
    private String published;
    private String ISBN;
    private String price;

    public int getId() {
        return id;
    }

    public Book setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Book setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Book setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public Book setAuthor(String author) {
        this.author = author;
        return this;
    }

    public String getPublisher() {
        return publisher;
    }

    public Book setPublisher(String publisher) {
        this.publisher = publisher;
        return this;
    }

    public String getPublished() {
        return published;
    }

    public Book setPublished(String published) {
        this.published = published;
        return this;
    }

    public String getISBN() {
        return ISBN;
    }

    public Book setISBN(String ISBN) {
        this.ISBN = ISBN;
        return this;
    }

    public String getPrice() {
        return price;
    }

    public Book setPrice(String price) {
        this.price = price;
        return this;
    }

    private List<String> tags;

    public List<String> getTags() {
        return tags;
    }

    public Book setTags(List<String> tags) {
        this.tags = tags;
        return this;
    }
}
