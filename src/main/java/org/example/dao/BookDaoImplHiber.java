package org.example.dao;

import org.example.model.Book;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.hibernate.Session;
import java.util.List;


@Repository
public class BookDaoImplHiber implements BookDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(BookDaoImplHiber.class);
    private final SessionFactory sessionFactory;

    @Autowired
    public BookDaoImplHiber(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Book book) {
        LOGGER.info("BookDaoImpl .add(" + book + ") called.");
        Session session = sessionFactory.getCurrentSession();
        session.persist(book);
        LOGGER.info("BookDaoImpl .add(" + book + ") executed.");

    }

    @Override
    public void update(Book book) {
        LOGGER.info("BookDaoImpl .update(" + book + ") called.");
        Session session = sessionFactory.getCurrentSession();
        session.merge(book);
        LOGGER.info("BookDaoImpl .update(" + book + ") executed.");
    }

    @Override
    public void remove(long id) {
        LOGGER.info("BookDaoImpl .remove(" + id + ") called.");
        Session session = sessionFactory.getCurrentSession();
        session.remove(id);
        LOGGER.info("BookDaoImpl .remove(" + id + ") executed.");
    }

    @Override
    public Book getById(long id) {
        LOGGER.info("BookDaoImpl .getByTd(" + id + ") called.");
        Session session = sessionFactory.getCurrentSession();
        Book bookFromDb = session.getReference(Book.class, id);
        LOGGER.info("BookDaoImpl .getByTd(" + id + ") executed. Got " + bookFromDb);
        return bookFromDb;
    }

    @Override
    public List<Book> getAll() {
        LOGGER.info("BookDaoImpl .getAll() called.");
        Session session = sessionFactory.getCurrentSession();
        List<Book> bookList = session.createQuery("SELECT b FROM Book b", Book.class).getResultList();
        LOGGER.info("BookDaoImpl .getAll() executed. Got [" + bookList.size() + "] elements.");
        return bookList;
    }
}
