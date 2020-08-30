//package org.example.dao;
//
//import org.example.model.Book;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import java.util.List;
//
//
//@Repository
//public class BookDaoImpl implements BookDao {
//    private static final Logger LOGGER = LoggerFactory.getLogger(BookDaoImpl.class);
//    private EntityManagerFactory emf;
//
//    @Autowired
//    public void setEmf(EntityManagerFactory emf) {
//        this.emf = emf;
//    }
//
//    @Override
//    public void add(Book book) {
//        LOGGER.info("BookDaoImpl .add(" + book + ") called.");
//        EntityManager em = emf.createEntityManager();
//        em.persist(book);
//        em.close();
//        LOGGER.info("BookDaoImpl .add(" + book + ") executed.");
//
//    }
//
//    @Override
//    public void update(Book book) {
//        LOGGER.info("BookDaoImpl .update(" + book + ") called.");
//        EntityManager em = emf.createEntityManager();
//        em.merge(book);
//        em.close();
//        LOGGER.info("BookDaoImpl .update(" + book + ") executed.");
//    }
//
//    @Override
//    public void remove(long id) {
//        LOGGER.info("BookDaoImpl .remove(" + id + ") called.");
//        EntityManager em = emf.createEntityManager();
//        em.remove(id);
//        em.close();
//        LOGGER.info("BookDaoImpl .remove(" + id + ") executed.");
//    }
//
//    @Override
//    public Book getById(long id) {
//        LOGGER.info("BookDaoImpl .getByTd(" + id + ") called.");
//        EntityManager em = emf.createEntityManager();
//        Book bookFromDb = em.getReference(Book.class, id);
//        em.close();
//        LOGGER.info("BookDaoImpl .getByTd(" + id + ") executed. Got " + bookFromDb);
//        return bookFromDb;
//    }
//
//    @Override
//    public List<Book> getAll() {
//        LOGGER.info("BookDaoImpl .getAll() called.");
//        EntityManager em = emf.createEntityManager();
//        List<Book> bookList = em.createQuery("SELECT b FROM Book b", Book.class).getResultList();
//        em.close();
//        LOGGER.info("BookDaoImpl .getAll() executed. Got [" + bookList.size() + "] elements.");
//        return bookList;
//    }
//}
