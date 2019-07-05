package edu.bjtu.xxq.dao;

import edu.bjtu.xxq.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDao {

    List<Book> findBookByTag(String tag);

    List<Book> getAll();

    int getPrice(String bookId);

    Book findById(int id);


}
