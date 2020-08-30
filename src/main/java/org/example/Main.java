package org.example;

import org.example.config.HibernateConfig;
import org.example.model.Book;
import org.example.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    // for this main-method take-off comments from HibernateConfig.java and BookDaoImplHiber.java
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(HibernateConfig.class);
             Scanner scanner = new Scanner(System.in)) {


            BookService bookService = context.getBean("bookServiceImpl", BookService.class);
            testBooks().forEach(bookService::add);
            bookService.getAll().forEach(System.out::println);
//            scanner.nextLine();
        }
    }

    // for this main-method take-off comments from JpaConfig.java and BookDaoImpl.java
//    public static void main(String[] args) {
//        try (AnnotationConfigApplicationContext context =
//                     new AnnotationConfigApplicationContext(JpaConfig.class);
//             Scanner scanner = new Scanner(System.in)) {
//
//
//            BookService bookService = context.getBean("bookServiceImpl", BookService.class);
//            testBooks().forEach(bookService::add);
//            bookService.getAll().forEach(System.out::println);
//            scanner.nextLine();
//        }
//    }

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
