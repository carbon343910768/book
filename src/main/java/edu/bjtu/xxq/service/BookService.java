package edu.bjtu.xxq.service;

import edu.bjtu.xxq.dao.BookDao;
import edu.bjtu.xxq.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    public List<Integer> loadBooksByTag(String tag, int start, int limit) {
        return bookDao.findBooksByTag(tag, start, limit);
    }

    public Book getOne(int id) {
        return bookDao.findBookById(id);
    }

    public List<Book> getList(Integer[] id) {
        return bookDao.findBooksById(Arrays.asList(id));
    }

    public List<Integer> getBookPhotos(int id) {
        return bookDao.findBookImages(id);
    }

//    public List<Book> loadBookByName(String bookName) {
//        String name = "%" + bookName + "%";
//        return bookDao.findBookByName(name);
//    }

}
