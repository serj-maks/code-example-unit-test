package edu.serjmaks.junit.ex02.task2.task2_VI.model;

import java.util.Objects;

public class Book {
    private String title;
    private int numberOfPages;
    private Author author;

    public Book(String title, int numberOfPages) {
        this.title = title;
        this.numberOfPages = numberOfPages;
    }

    public String getTitle() {
        return title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public Author getAuthor() {
        return author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", numberOfPages=" + numberOfPages +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return numberOfPages == book.numberOfPages && Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, numberOfPages);
    }
}
