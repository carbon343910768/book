package edu.bjtu.xxq.dao;

import edu.bjtu.xxq.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDao {

    Book findBookById(int id);

    List<Book> findBooksById(List<Integer> id);

    List<Integer> findBookImages(int id);

    List<String> findBookTags(int id);

    List<Integer> findBooksByTag(String tag, int start, int limit);

    List<Integer> search1(String name);

    List<Integer> search2(String name, String author);

    List<Integer> search3(String name, String author, String publisher);

    void addBook(Book book);

    void addBookImage(int bookId, int imageId);

    void addBookTag(int book, String tag);

}
