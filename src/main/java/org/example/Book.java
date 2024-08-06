package org.example;

import java.util.Objects;

public class Book {
    private String title;
    private String author;
    private int publicationYear;
    private int pages;
    private String category;
    private boolean isOnLoan;

    public Book(String title, String author, int publicationYear, int pages, String category) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.pages = pages;
        this.category = category;
        this.isOnLoan = false;
    }

    // Getters and Setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public int getPublicationYear() { return publicationYear; }
    public void setPublicationYear(int publicationYear) { this.publicationYear = publicationYear; }
    public int getPages() { return pages; }
    public void setPages(int pages) { this.pages = pages; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public boolean isOnLoan() { return isOnLoan; }
    public void setOnLoan(boolean onLoan) { isOnLoan = onLoan; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return publicationYear == book.publicationYear &&
                pages == book.pages &&
                isOnLoan == book.isOnLoan &&
                Objects.equals(title, book.title) &&
                Objects.equals(author, book.author) &&
                Objects.equals(category, book.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, publicationYear, pages, category, isOnLoan);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publicationYear=" + publicationYear +
                ", pages=" + pages +
                ", category='" + category + '\'' +
                ", isOnLoan=" + isOnLoan +
                '}';
    }
}
