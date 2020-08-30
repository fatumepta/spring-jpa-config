package org.example.service;

import org.example.dao.BookDao;
import org.example.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class BookServiceImpl implements BookService {
    private static final Logger LOGGER = LoggerFactory.getLogger(BookServiceImpl.class);
    private BookDao bookDao;

    @Autowired
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    @Transactional
    public void add(Book book) {
        LOGGER.info("BookServiceImpl .add(" + book + ") called.");
        this.bookDao.add(book);
        LOGGER.info("BookServiceImpl .add(" + book + ") executed.");
    }

    @Override
    @Transactional
    public void update(Book book) {
        LOGGER.info("BookServiceImpl .update(" + book + ") called.");
        this.bookDao.update(book);
        LOGGER.info("BookServiceImpl .update(" + book + ") executed.");
    }

    @Override
    @Transactional
    public void remove(long id) {
        LOGGER.info("BookServiceImpl .remove(" + id + ") called.");
        this.bookDao.remove(id);
        LOGGER.info("BookServiceImpl .remove(" + id + ") executed.");
    }

    @Override
    @Transactional
    public Book getById(long id) {
        LOGGER.info("BookServiceImpl .getByTd(" + id + ") called.");
        Book bookFromDb = this.bookDao.getById(id);
        LOGGER.info("BookServiceImpl .getByTd(" + id + ") executed. Got " + bookFromDb);
        return bookFromDb;
    }

    @Override
    @Transactional
    public List<Book> getAll() {
        LOGGER.info("BookServiceImpl .getAll() called.");
        List<Book> bookList = this.bookDao.getAll();
        LOGGER.info("BookServiceImpl .getAll() executed. Got [" + bookList.size() + "] elements.");
        return bookList;
    }
}
