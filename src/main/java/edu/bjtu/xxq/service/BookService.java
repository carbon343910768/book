package edu.bjtu.xxq.service;

import edu.bjtu.xxq.dao.BookDao;
import edu.bjtu.xxq.dao.ImageDao;
import edu.bjtu.xxq.model.Book;
import edu.bjtu.xxq.model.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
        Book book = bookDao.findBookById(id);
        if (book != null) book.setTags(bookDao.findBookTags(id));
        return book;
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

    public List<Integer> search(String search) {
        String[] keys = search.split("[ ]+");
        switch (keys.length) {
            case 0:
                return new LinkedList<>();
            case 1:
                return bookDao.search1(keys[0]);
            case 2:
                return bookDao.search2(keys[0], keys[1]);
            default:
                return bookDao.search3(keys[0], keys[1], keys[2]);
        }
    }

    public int addBook(Book book) {
        bookDao.addBook(book);
        return book.getId();
    }

    public void addBookImage(int bookId, byte[] image) {
        Image img = new Image().setContent(image);
        imageDao.addImage(img);
        bookDao.addBookImage(bookId, img.getId());
    }

    public void addTag(int bookId, String bookTag) {
        bookDao.addBookTag(bookId, bookTag);
    }

}
