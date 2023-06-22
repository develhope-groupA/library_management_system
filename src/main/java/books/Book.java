package books;

import java.util.Set;
import java.util.Map;
import java.util.List;
import java.util.HashSet;
import java.util.HashMap;
import java.util.ArrayList;

public class Book {

    // Instance variables
    private Set<String> Titles; // Set to store book titles
    private Map<String, String> Authors; // Map to store book authors mapped to book titles
    private List<String[]> PublicationYears; // List to store book titles and publication years
    private int totalBooks; // Total number of books in the library

    // Constructor
    public Book(String adventures, String makena, int i) {
        Titles = new HashSet<>();
        Authors = new HashMap<>();
        PublicationYears = new ArrayList<>();
        totalBooks = 0;
    }

    // Method to add a book to the library
    public void addBook(String title, String author, int publicationYear) {
        Titles.add(title);
        Authors.put(author, title);
        PublicationYears.add(new String[]{title, String.valueOf(publicationYear)});
        totalBooks++;
    }

    // Method to check if a book is in the library
    public boolean isBookInLibrary(String title) {
        return Titles.contains(title);
    }

    // Method to get books by a specific author
    public List<String> getBooksByAuthor(String author) {
        List<String> books = new ArrayList<>();
        for (String book : Authors.keySet()) {
            if (Authors.get(book).equals(author)) {
                books.add(book);
            }
        }
        return books;
    }

    // Method to get books published in a specific year
    public List<String> getBooksPublishedInYear(int year) {
        List<String> books = new ArrayList<>();
        for (String[] book : PublicationYears) {
            if (Integer.parseInt(book[1]) == year) {
                books.add(book[0]);
            }
        }
        return books;
    }

    // Method to remove a book from the library
    public void removeBook(String title) {
        if (isBookInLibrary(title)) {
            Titles.remove(title);
            Authors.remove(title);
            PublicationYears.removeIf(book -> book[0].equals(title));
            totalBooks--;
        } else {
            System.out.println("The book is not in the library.");
        }
    }

    // Method to update the details of a book in the library
    public void updateBookDetails(String title, String newTitle, String newAuthor, int newPublicationYear) {
        if (isBookInLibrary(title)) {
            Titles.remove(title);
            Authors.remove(title);
            PublicationYears.removeIf(book -> book[0].equals(title));

            Titles.add(newTitle);
            Authors.put(newAuthor, newTitle);
            PublicationYears.add(new String[]{newTitle, String.valueOf(newPublicationYear)});
        } else {
            System.out.println("The book is not in the library.");
        }
    }


    public Object getTitle() {
        return Titles;
    }

    public Object getAuthor() {
        return Authors;
    }

    public Object getPublicationYears() {
        return PublicationYears;
    }
}