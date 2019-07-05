package edu.bjtu.xxq.service;

import edu.bjtu.xxq.dao.BookDao;
import edu.bjtu.xxq.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    public List<Book> loadBookByTag(String tag) {
        return bookDao.findBookByTag(tag);
    }

    public List<Book> getAll() {
        return bookDao.getAll();
    }

    public int getPrice(String bookId) {
        return bookDao.getPrice(bookId);
    }

}
