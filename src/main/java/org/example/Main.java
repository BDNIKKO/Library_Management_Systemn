package org.example;

import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        Library library = new Library();
        User user1 = new User("Alice", "12345");
        User user2 = new User("Bob", "67890");

        // Add books to the library
        library.addBook(new Book("Java Programming", "John Doe", 2020, 500, "Education"));
        library.addBook(new Book("Python Essentials", "Jane Smith", 2019, 300, "Education"));
        library.addBook(new Book("History of Art", "Emily White", 2018, 200, "History"));
        library.addBook(new Book("Science for Kids", "David Brown", 2021, 150, "Science"));

        // Print all book titles in the library
        System.out.println("All book titles:");
        library.printAllBookTitles();

        // Find books by author
        System.out.println("\nBooks by Jane Smith:");
        List<Book> booksByAuthor = library.findBooksByAuthor("Jane Smith");
        booksByAuthor.forEach(System.out::println);

        // Loan out a book to a user
        System.out.println("\nLoan out 'Java Programming' to Alice:");
        library.loanBook("Java Programming");
        library.findBooksByTitle("Java Programming").stream().findFirst().ifPresent(user1::loanBook);
        System.out.println(user1);

        // Attempt to loan the same book to another user
        System.out.println("\nAttempt to loan 'Java Programming' to Bob:");
        library.loanBook("Java Programming");
        library.findBooksByTitle("Java Programming").stream().findFirst().ifPresent(user2::loanBook);
        System.out.println(user2);

        // Return the book from Alice
        System.out.println("\nAlice returns 'Java Programming':");
        library.findBooksByTitle("Java Programming").stream().findFirst().ifPresent(user1::returnBook);
        library.returnBook("Java Programming");
        System.out.println(user1);

        // Now loan the book to Bob
        System.out.println("\nLoan out 'Java Programming' to Bob:");
        library.loanBook("Java Programming");
        library.findBooksByTitle("Java Programming").stream().findFirst().ifPresent(user2::loanBook);
        System.out.println(user2);

        // Remove a book by title
        System.out.println("\nRemoving 'Python Essentials' from the library:");
        library.removeBookByTitle("Python Essentials");
        System.out.println("All book titles after removal:");
        library.printAllBookTitles();

        // Find the book with the most pages
        System.out.println("\nBook with the most pages:");
        Optional<Book> bookWithMostPages = library.findBookWithMostPages();
        bookWithMostPages.ifPresent(System.out::println);

        // Find all books with more than 250 pages
        System.out.println("\nBooks with more than 250 pages:");
        List<Book> booksWithMorePages = library.findBooksWithMoreThanNPages(250);
        booksWithMorePages.forEach(System.out::println);

        // Find all books in the 'Education' category
        System.out.println("\nBooks in the 'Education' category:");
        List<Book> educationBooks = library.findBooksByCategory("Education");
        educationBooks.forEach(System.out::println);

        // Print publication years of all books
        System.out.println("\nPublication years of all books:");
        library.getBooks().forEach(book -> System.out.println(book.getTitle() + " was published in " + book.getPublicationYear()));

        // Demonstrate use of User getters and calculateLateFees
        System.out.println("\nUser information:");
        System.out.println("Name: " + user1.getName());
        System.out.println("Library Card Number: " + user1.getLibraryCardNumber());
        System.out.println("Books on Loan: " + user1.getBooksOnLoan());
        System.out.println("Loan Date: " + user1.getLoanDate());

        // Loan a book to demonstrate late fees
        System.out.println("\nLoan out 'Science for Kids' to Alice:");
        library.loanBook("Science for Kids");
        library.findBooksByTitle("Science for Kids").stream().findFirst().ifPresent(user1::loanBook);
        System.out.println(user1);

        System.out.println("Late Fees: " + user1.calculateLateFees());
    }
}
