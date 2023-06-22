package library;

import java.util.ArrayList; // import the ArrayList class
import java.util.Arrays;

public class AddBooksToLibrary {

    public static void main(String[] args) {
       var Library1 = new Library();

       var book1 = new Book("The River", "Maffie Blac", 2000);

       Library1.addBooks(book1);

       System.out.println(Library1.getBookCollection());

    }
}



class Library{

    private ArrayList<Book> bookCollection;

    public Library(){
        this.bookCollection =  new ArrayList<Book>(); // Create an ArrayList object
    }
    public void addBooks(Book... books){
        for (Book b: books) {
            bookCollection.add(b);
        }
    }

    public ArrayList<Book> getBookCollection(){
        return this.bookCollection;

    }
}


class Book {
    public String title;
    public String author;
    public int publicationYear;

    public Book(String title,String author,int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publicationYear=" + publicationYear +
                '}';
    }

}

