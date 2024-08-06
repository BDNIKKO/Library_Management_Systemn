package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Library {
    private final List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    // Add a book to the library
    public void addBook(Book book) {
        books.add(book);
    }

    // Remove a book from the library by title
    public void removeBookByTitle(String title) {
        books.removeIf(book -> book.getTitle().equalsIgnoreCase(title));
    }

    // Find all books by a specific author
    public List<Book> findBooksByAuthor(String author) {
        return books.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    // Find the book with the most pages
    public Optional<Book> findBookWithMostPages() {
        return books.stream()
                .max(Comparator.comparingInt(Book::getPages));
    }

    // Find all books with more than n pages
    public List<Book> findBooksWithMoreThanNPages(int n) {
        return books.stream()
                .filter(book -> book.getPages() > n)
                .collect(Collectors.toList());
    }

    // Print all book titles in the library, sorted alphabetically
    public void printAllBookTitles() {
        books.stream()
                .map(Book::getTitle)
                .sorted()
                .forEach(System.out::println);
    }

    // Find all books in a specific category
    public List<Book> findBooksByCategory(String category) {
        return books.stream()
                .filter(book -> book.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    // Find books by title
    public List<Book> findBooksByTitle(String title) {
        return books.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
    }

    // Loan out a book
    public void loanBook(String title) {
        books.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title) && !book.isOnLoan())
                .findFirst()
                .ifPresent(book -> book.setOnLoan(true));
    }

    // Return a book
    public void returnBook(String title) {
        books.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title) && book.isOnLoan())
                .findFirst()
                .ifPresent(book -> book.setOnLoan(false));
    }

    public List<Book> getBooks() {
        return books;
    }
}
