package org.example;

import org.example.model.Book;
import org.example.service.BookService;
import org.example.service.BookServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;


public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {

            BookService bookService = context.getBean("bookServiceImpl", BookServiceImpl.class);
            testBooks().forEach(bookService::add);
            LOGGER.info("Test books added.");
            bookService.getAll().forEach(System.out::println);

        }
    }

    private static List<Book> testBooks() {
        Book b1 = new Book();
        b1.setAuthor("A1");
        b1.setTitle("T1");
        b1.setPrice(1000);

        Book b2 = new Book();
        b2.setAuthor("A2");
        b2.setTitle("T2");
        b2.setPrice(2000);

        Book b3 = new Book();
        b3.setAuthor("A3");
        b3.setTitle("T3");
        b3.setPrice(3000);

        Book b4 = new Book();
        b4.setAuthor("A4");
        b4.setTitle("T4");
        b4.setPrice(4000);

        return Arrays.asList(b1, b2, b3, b4);
    }
}
