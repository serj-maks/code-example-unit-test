package edu.serjmaks.junit.ex02.task2.controller;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import edu.serjmaks.junit.ex02.task2.model.Author;
import edu.serjmaks.junit.ex02.task2.model.Book;

public class BookActions {

    public static boolean isNumbersMoreThan200(Book[] books) {
        return Arrays.stream(books)
                .anyMatch(book -> book.getNumberOfPages() > 200);
    }

    public static Optional<Book> getMax(Book[] books) {
        return Stream.of(books)
                .max(Comparator.comparing(Book::getNumberOfPages));
    }

    public static Optional<Book> getMin(Book[] books) {
        return Stream.of(books)
                .min(Comparator.comparing(Book::getNumberOfPages));
    }

    public static List<Book> getBooks(String name, List<Author> authors) {
        return authors.stream()
                .filter(author -> author.getName().equals(name))
                .map(author -> author.getBooks())
                .flatMap(book -> book.stream())
                .collect(Collectors.toList());
    }

    public static List<Book> booksByNumberOfPagesAndTitle(List<Author> authors) {
        return authors.stream()
                .map(author -> author.getBooks())
                .flatMap(book -> book.stream())
                .sorted(Comparator.comparing(Book::getNumberOfPages).thenComparing(Book::getTitle))
                .collect(Collectors.toList());
    }

    public static Map<String, List<Book>> getMap(List<Author> authors) {
        return authors.stream()
                .collect(Collectors.toMap(Author::getName, Author::getBooks));
    }
}
