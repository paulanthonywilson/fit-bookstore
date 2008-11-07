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

    public Book findBookById(int id) {
        for (Book book : allBooks) {
            if (id == book.getId()) return book;
        }
        throw new BookNotFoundException("Can not find book with id '" + id + "'");
    }
}
