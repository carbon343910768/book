package edu.bjtu.xxq.dao;

import edu.bjtu.xxq.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDao {

    List<Book> findBooksByTag(String tag, int start, int limit);

    Book findBookById(int id);

    List<Book> findBooksById(List<Integer> id);

}
