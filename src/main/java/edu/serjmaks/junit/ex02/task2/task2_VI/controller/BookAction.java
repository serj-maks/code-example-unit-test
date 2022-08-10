package edu.serjmaks.junit.ex02.task2.task2_VI.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import edu.serjmaks.junit.ex02.task2.task2_VI.model.Author;
import edu.serjmaks.junit.ex02.task2.task2_VI.model.Book;

public class BookAction {

    public static Map<Author, Long> getBookCount(List<Book> books) {
        return books.stream()
                .collect(Collectors.groupingBy(Book::getAuthor, Collectors.counting()));
    }
}
