package org.example;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("The Last Wish", "Andrzej Sapkowski", 1993, 384, "Fantasy");
        Book book2 = new Book("Sword of Destiny", "Andrzej Sapkowski", 1992, 400, "Fantasy");
        Book book3 = new Book("Blood of Elves", "Andrzej Sapkowski", 1994, 320, "Fantasy");
        Book book4 = new Book("Time of Contempt", "Andrzej Sapkowski", 1995, 432, "Fantasy");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);

        User triss = new User("Triss", "12345");
        User yennefer = new User("Yennefer", "67890");

        library.addUser(triss);
        library.addUser(yennefer);

        System.out.println("All book titles:");
        library.printAllBookTitles();

        System.out.println("\nBooks by Andrzej Sapkowski:");
        library.findBooksByAuthor("Andrzej Sapkowski").forEach(System.out::println);

        System.out.println("\nLoan out 'The Last Wish' to Triss:");
        library.loanBookToUser("The Last Wish", triss);
        System.out.println(triss);

        System.out.println("\nAttempt to loan 'The Last Wish' to Yennefer:");
        library.loanBookToUser("The Last Wish", yennefer);
        System.out.println(yennefer);

        System.out.println("\nTriss returns 'The Last Wish':");
        library.returnBookFromUser("The Last Wish", triss);
        System.out.println(triss);

        System.out.println("\nLoan out 'The Last Wish' to Yennefer:");
        library.loanBookToUser("The Last Wish", yennefer);
        System.out.println(yennefer);

        System.out.println("\nRemoving 'Sword of Destiny' from the library:");
        library.removeBookByTitle("Sword of Destiny");
        System.out.println("All book titles after removal:");
        library.printAllBookTitles();

        System.out.println("\nBook with the most pages:");
        System.out.println(library.findBookWithMostPages());

        System.out.println("\nBooks with more than 250 pages:");
        library.findBooksWithMoreThanNPages(250).forEach(System.out::println);

        System.out.println("\nBooks in the 'Fantasy' category:");
        library.findBooksByCategory("Fantasy").forEach(System.out::println);

        System.out.println("\nPublication years of all books:");
        library.findBooksByYear(1993).forEach(book -> System.out.println(book.getTitle() + " was published in " + book.getPublicationYear()));
        library.findBooksByYear(1992).forEach(book -> System.out.println(book.getTitle() + " was published in " + book.getPublicationYear()));
        library.findBooksByYear(1994).forEach(book -> System.out.println(book.getTitle() + " was published in " + book.getPublicationYear()));
        library.findBooksByYear(1995).forEach(book -> System.out.println(book.getTitle() + " was published in " + book.getPublicationYear()));

        System.out.println("\nUser information:");
        System.out.println("Name: " + triss.getName());
        System.out.println("Library Card Number: " + triss.getLibraryCardNumber());
        System.out.println("Books on Loan: " + triss.getBooksOnLoan());
        System.out.println("Loan Date: " + triss.getLoanDate());

        System.out.println("\nLoan out 'Time of Contempt' to Triss:");
        library.loanBookToUser("Time of Contempt", triss);
        System.out.println(triss);
        System.out.println("Late Fees: " + triss.calculateLateFees());

        // Query users by name
        System.out.println("\nFind users named 'Triss':");
        library.findUsersByName("Triss").forEach(System.out::println);

        // Query users by library card number
        System.out.println("\nFind user with library card number '67890':");
        System.out.println(library.findUserByLibraryCardNumber("67890"));
    }
}
