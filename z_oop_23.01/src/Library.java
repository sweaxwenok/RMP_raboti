import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> searchByAuthor(String author) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    public List<Book> searchByYear(int year) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getYear() == year) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    public void displayAllBooks() {
        for(Book book: books){
            System.out.println(book.toString());
        }
    }
}