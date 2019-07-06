package edu.bjtu.xxq.service;

import edu.bjtu.xxq.dao.BookDao;
import edu.bjtu.xxq.dao.ImageDao;
import edu.bjtu.xxq.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookDao bookDao;
    @Autowired
    private ImageDao imageDao;

    public List<Integer> getBooksByTag(String tag, int start, int limit) {
        return bookDao.findBooksByTag(tag, start, limit);
    }

    public Book getOne(int id) {
        return bookDao.findBookById(id);
    }

    public List<Book> getList(Integer[] id) {
        return bookDao.findBooksById(Arrays.asList(id));
    }

    public List<Integer> getBookImages(int id) {
        return bookDao.findBookImages(id);
    }

    public List<String> getBookTags(int id) {
        return bookDao.findBookTags(id);
    }

    public int addBook(Book book) {
        bookDao.addBook(book);
        return 1;
    }

    public void addBookImage(int bookId, byte[] image) {
        int imageId = imageDao.addImage(image);
        bookDao.addBookImage(bookId, imageId);
    }

    public boolean addTag(int bookId, String bookTag) {
        bookDao.addBookTag(bookId, bookTag);
        return true;
    }

//    public List<Book> loadBookByName(String bookName) {
//        String name = "%" + bookName + "%";
//        return bookDao.findBookByName(name);
//    }

}
