package edu.serjmaks.junit.ex02.task2.task2_VI.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Author implements Comparable<Author> {
    private String name;
    private List<Book> books = new ArrayList<>();


    public Author(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", books=" + books +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(name, author.name) && Objects.equals(books, author.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, books);
    }

    @Override
    public int compareTo(Author o) {
        return name.compareTo(o.name);
    }

}
