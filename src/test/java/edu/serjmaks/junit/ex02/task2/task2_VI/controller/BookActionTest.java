package edu.serjmaks.junit.ex02.task2.task2_VI.controller;

import org.junit.jupiter.api.Test;

import edu.serjmaks.junit.ex02.task2.task2_VI.controller.BookAction;
import edu.serjmaks.junit.ex02.task2.task2_VI.model.Author;
import edu.serjmaks.junit.ex02.task2.task2_VI.model.Book;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BookActionTest {

    @Test
    void getBookCount() {
        Book book1 = new Book("book1", 100);
        Book book2 = new Book("book2", 200);
        Book book3 = new Book("book3", 300);
        Author author = new Author("Fedor");
        author.addBook(book1);
        author.addBook(book2);
        author.addBook(book3);
        book1.setAuthor(author);
        book2.setAuthor(author);
        book3.setAuthor(author);

        Book expectedBook1 = new Book("book1", 100);
        Book expectedBook2 = new Book("book2", 200);
        Book expectedBook3 = new Book("book3", 300);
        Author expectedAuthor = new Author("Fedor");
        expectedAuthor.addBook(expectedBook1);
        expectedAuthor.addBook(expectedBook2);
        expectedAuthor.addBook(expectedBook3);
        expectedBook1.setAuthor(expectedAuthor);
        expectedBook2.setAuthor(expectedAuthor);
        expectedBook3.setAuthor(expectedAuthor);

        Map<Author, Long> expected = Map.of(expectedAuthor, 3L);
        Map<Author, Long> actual = BookAction.getBookCount(List.of(book1, book2, book3));
        assertEquals(expected, actual);
    }
}
