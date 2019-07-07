package edu.bjtu.xxq.dao;

import edu.bjtu.xxq.model.Book;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public interface BookDao {

    Book findBookById(int id);

    List<Book> findBooksById(List<Integer> id);

    List<Integer> findBookImages(int id);

    List<String> findBookTags(int id);

    List<Integer> findBooksByTag(String tag, int start, int limit);

    List<HashMap<Integer,Integer>> findBooksByManyTag(String name, String author, String publisher);

    void addBook(Book book);

    void addBookImage(int bookId, int imageId);

    void addBookTag(int book, String tag);

}
