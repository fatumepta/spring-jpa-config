package org.example.dao;

import org.example.model.Book;

import java.util.List;


public interface BookDao {
    void add(Book book);

    void update(Book book);

    void remove(long id);

    Book getById(long id);

    List<Book> getAll();
}
