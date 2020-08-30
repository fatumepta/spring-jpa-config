package org.example.service;

import org.example.model.Book;

import java.util.List;

public interface BookService {
    void add(Book book);

    void update(Book book);

    void remove(long id);

    Book getById(long id);

    List<Book> getAll();
}
