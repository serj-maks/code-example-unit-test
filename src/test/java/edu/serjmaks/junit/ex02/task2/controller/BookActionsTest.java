package edu.serjmaks.junit.ex02.task2.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import edu.serjmaks.junit.ex02.task2.controller.BookActions;
import edu.serjmaks.junit.ex02.task2.model.Author;
import edu.serjmaks.junit.ex02.task2.model.Book;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class BookActionsTest {

    @Test
    void isNumberMoreThan200() {
        Book[] books = {
                new Book("Crime and Punishment", 300),
                new Book("War and Peace", 400),
                new Book("Ruslan and Ludmila", 100)
        };

        boolean expected = true;
        boolean actual = BookActions.isNumbersMoreThan200(books);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("empty array")
    void isNumberMoreThan200_ShouldReturnFalse_onEmptyArray() {
        Book[] books = {

        };

        boolean actual = BookActions.isNumbersMoreThan200(books);
        assertFalse(actual);
    }

    @Test
    @DisplayName("array don't contain book with 200 or more pages")
    void isNumberMoreThan200_ShouldReturnFalse_onMissingBook() {
        Book[] books = {
                new Book("Crime and Punishment", 30),
                new Book("War and Peace", 40),
                new Book("Ruslan and Ludmila", 100)
        };

        boolean actual = BookActions.isNumbersMoreThan200(books);
        assertFalse(actual);
    }

    @Test
    void getMax() {
        Book[] books = {
                new Book("Crime and Punishment", 300),
                new Book("War and Peace", 400),
                new Book("Ruslan and Ludmila", 100)
        };

        Optional<Book> expected = Optional.of(new Book("War and Peace", 400));
        Optional<Book> actual = BookActions.getMax(books);
        assertEquals(expected, actual);
    }

    @Test
    void getMax_shouldReturnOptionalEmpty() {
        Book[] books = {
        };

        Optional<Book> expected = Optional.empty();
        Optional<Book> actual = BookActions.getMax(books);
        assertEquals(expected, actual);
    }

    @Test
    void getMin() {
        Book[] books = {
                new Book("Crime and Punishment", 300),
                new Book("War and Peace", 400),
                new Book("Ruslan and Ludmila", 100)
        };

        Optional<Book> expected = Optional.of(new Book("Ruslan and Ludmila", 100));
        Optional<Book> actual = BookActions.getMin(books);
        assertEquals(expected, actual);
    }

    @Test
    void getMin_shouldReturnOptionalEmpty() {
        Book[] books = {
        };

        Optional<Book> expected = Optional.empty();
        Optional<Book> actual = BookActions.getMin(books);
        assertEquals(expected, actual);
    }

    @Test
    void getBooks() {
        List<Book> fedorBooks = List.of(
                new Book("fedorBook1", 100),
                new Book("fedorBook2", 200),
                new Book("fedorBook3", 300)
        );
        List<Book> leoBooks = List.of(
                new Book("leoBook1", 400),
                new Book("leoBook2", 500),
                new Book("leoBook3", 600)
        );
        List<Book> aleksandrBooks = List.of(
                new Book("aleksandrBook1", 700),
                new Book("aleksandrBook2", 800),
                new Book("aleksandrBook3", 900)
        );
        List<Author> authors = List.of(
                new Author("Fedor", fedorBooks),
                new Author("Leo", leoBooks),
                new Author("Aleksandr", aleksandrBooks)
        );
        List<Book> expectedList = List.of(
                new Book("aleksandrBook1", 700),
                new Book("aleksandrBook2", 800),
                new Book("aleksandrBook3", 900)
        );

        List<Book> expected = expectedList;
        List<Book> actual = BookActions.getBooks("Aleksandr", authors);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("giving empty list to parameter")
    void getBooks_shouldReturnTrue() {
        List<Book> fedorBooks = List.of(
                new Book("fedorBook1", 100),
                new Book("fedorBook2", 200),
                new Book("fedorBook3", 300)
        );
        List<Book> leoBooks = List.of(
                new Book("leoBook1", 400),
                new Book("leoBook2", 500),
                new Book("leoBook3", 600)
        );
        List<Book> aleksandrBooks = List.of(

        );
        List<Author> authors = List.of(
                new Author("Fedor", fedorBooks),
                new Author("Leo", leoBooks),
                new Author("Aleksandr", aleksandrBooks)
        );

        List<Book> actual = BookActions.getBooks("Aleksandr", authors);
        assertTrue(actual.isEmpty());
    }

    @Test
    void sortedBooks() {
        List<Book> fedorBooks = List.of(
                new Book("fedorBook1", 100),
                new Book("fedorBook2", 200),
                new Book("fedorBook3", 300)
        );
        List<Book> leoBooks = List.of(
                new Book("leoBook1", 400),
                new Book("leoBook2", 500),
                new Book("leoBook3", 600)
        );
        List<Book> aleksandrBooks = List.of(
                new Book("aleksandrBook1", 700),
                new Book("aleksandrBook2", 800),
                new Book("aleksandrBook3", 900)
        );
        List<Author> authors = List.of(
                new Author("Fedor", fedorBooks),
                new Author("Leo", leoBooks),
                new Author("Aleksandr", aleksandrBooks)
        );
        List<Book> expectedList = List.of(
                new Book("fedorBook1", 100),
                new Book("fedorBook2", 200),
                new Book("fedorBook3", 300),
                new Book("leoBook1", 400),
                new Book("leoBook2", 500),
                new Book("leoBook3", 600),
                new Book("aleksandrBook1", 700),
                new Book("aleksandrBook2", 800),
                new Book("aleksandrBook3", 900)
        );

        List<Book> expected = expectedList;
        List<Book> actual = BookActions.booksByNumberOfPagesAndTitle(authors);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("giving empty list to parameter")
    void sortedBooks_shouldReturnTrue() {
        List<Book> fedorBooks = List.of(

        );
        List<Book> leoBooks = List.of(

        );
        List<Book> aleksandrBooks = List.of(

        );
        List<Author> authors = List.of(
                new Author("Fedor", fedorBooks),
                new Author("Leo", leoBooks),
                new Author("Aleksandr", aleksandrBooks)
        );

        List<Book> actual = BookActions.booksByNumberOfPagesAndTitle(authors);
        assertTrue(actual.isEmpty());
    }

    @Test
    void getMap() {
        List<Book> fedorBooks = List.of(
                new Book("fedorBook1", 100),
                new Book("fedorBook2", 200),
                new Book("fedorBook3", 300)
        );
        List<Book> leoBooks = List.of(
                new Book("leoBook1", 400),
                new Book("leoBook2", 500),
                new Book("leoBook3", 600)
        );
        List<Book> aleksandrBooks = List.of(
                new Book("aleksandrBook1", 700),
                new Book("aleksandrBook2", 800),
                new Book("aleksandrBook3", 900)
        );
        List<Author> authors = List.of(
                new Author("Fedor", fedorBooks),
                new Author("Leo", leoBooks),
                new Author("Aleksandr", aleksandrBooks)
        );
        Map<String, List<Book>> expected = new HashMap<>();
        expected.put("Fedor", fedorBooks);
        expected.put("Leo", leoBooks);
        expected.put("Aleksandr", aleksandrBooks);
        Map<String, List<Book>> actual = BookActions.getMap(authors);
        assertEquals(expected, actual);
    }

    @Test
    void getMap_shouldReturnTrue() {
        List<Book> fedorBooks = List.of(

        );
        List<Book> leoBooks = List.of(

        );
        List<Book> aleksandrBooks = List.of(

        );
        List<Author> authors = List.of(

        );

        Map<String, List<Book>> actual = BookActions.getMap(authors);
        assertTrue(actual.isEmpty());
    }
}
