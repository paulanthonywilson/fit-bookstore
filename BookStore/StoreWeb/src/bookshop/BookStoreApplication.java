package bookshop;

import java.util.ArrayList;
import java.util.List;

public class BookStoreApplication  {
    private List<Book> allBooks = new ArrayList<Book>() ;

    public void addBook(Book book) {
        allBooks.add(book);
    }

    public List<Book> getAllBooks() {
        return allBooks;
    }
}
