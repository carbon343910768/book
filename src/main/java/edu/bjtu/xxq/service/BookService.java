package edu.bjtu.xxq.service;

import edu.bjtu.xxq.dao.BookDao;
import edu.bjtu.xxq.dao.ImageDao;
import edu.bjtu.xxq.model.Book;
import edu.bjtu.xxq.model.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
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
        return bookDao.findBookById(id).setTags(bookDao.findBookTags(id));
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

    public List<Integer> getBookBy3(String name, String author, String publisher) {
        return bookDao.search3(name, author, publisher);
    }

    public List<Integer> getBookBy2(String name, String author) {
        return bookDao.search2(name, author);
    }

    public List<Integer> getBookBy1(String name) {
        return bookDao.search1(name);
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
