package edu.bjtu.xxq.dao;

import edu.bjtu.xxq.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDao {

    List<Integer> findBooksByTag(String tag, int start, int limit);

    Book findBookById(int id);

    List<Book> findBooksById(List<Integer> id);

    List<Integer> findBookImages(int id);

    List<String> findBookTags(int id);

    // 返回book生成的id
    int addBook(Book book);

    void addBookImage(int bookId, int imageId);

    void addBookTag(int book, String tag);

}
