package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
    private final String name;
    private final String libraryCardNumber;
    private final List<Book> booksOnLoan;
    private LocalDate loanDate;

    public User(String name, String libraryCardNumber) {
        this.name = name;
        this.libraryCardNumber = libraryCardNumber;
        this.booksOnLoan = new ArrayList<>();
    }

    // Getters
    public String getName() { return name; }
    public String getLibraryCardNumber() { return libraryCardNumber; }
    public List<Book> getBooksOnLoan() { return booksOnLoan; }
    public LocalDate getLoanDate() { return loanDate; }

    // Loan a book to the user
    public void loanBook(Book book) {
        if (!book.isOnLoan()) {
            book.setOnLoan(true);
            booksOnLoan.add(book);
            loanDate = LocalDate.now();
        }
    }

    // Return a book from the user
    public void returnBook(Book book) {
        if (booksOnLoan.contains(book)) {
            book.setOnLoan(false);
            booksOnLoan.remove(book);
            // Reset loanDate if no books are on loan
            if (booksOnLoan.isEmpty()) {
                loanDate = null;
            }
        }
    }

    // Calculate late fees
    public double calculateLateFees() {
        if (loanDate == null) {
            return 0;
        }
        long daysLate = LocalDate.now().toEpochDay() - loanDate.toEpochDay();
        if (daysLate > 14) {
            return (daysLate - 14) * 0.5; // 0.5 cents per day late
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(libraryCardNumber, user.libraryCardNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, libraryCardNumber);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", libraryCardNumber='" + libraryCardNumber + '\'' +
                ", booksOnLoan=" + booksOnLoan +
                ", loanDate=" + loanDate +
                '}';
    }
}
