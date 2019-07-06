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

    void addBook(Book book);

    // 返回image生成的id，图片顺序sequence也是+1
    int addBookImage(int book, byte[] image);

    void addBookTag(int book, String tag);

}
