package org.example.model;

import org.example.model.aux.RegularEntity;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;


@Entity
public class Book extends RegularEntity {
    private String author;
    private String title;
    private double price;

    public Book() {
    }

    @Override
    public String toString() {
        return String.format("[Book -> [id: %d] [author: %s] [title: %s] [price: %s]", id, author, title, price);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
