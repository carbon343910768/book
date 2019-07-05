package edu.bjtu.xxq.service;

import edu.bjtu.xxq.dao.BookDao;
import edu.bjtu.xxq.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

//    public List<Book> loadBookByTag(String tag) {
//        return bookDao.findBookByTag(tag);
//    }

    public Book getOne(int id) {
        return bookDao.findBookById(id);
    }

    public List<Book> getList(Integer[] id) {
        return bookDao.findBooksById(Arrays.asList(id));
    }

//    public List<Book> loadBookByName(String bookName) {
//        String name = "%" + bookName + "%";
//        return bookDao.findBookByName(name);
//    }

}
