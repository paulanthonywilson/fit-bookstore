package bookshop;

import static bookshop.Pounds.inPounds;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Book> books = new ArrayList<Book>();

    public int getBookCount() {
        return books.size();
    }

    public void add(Book book) {
        books.add(book);
    }


    public Pounds getTotal() {
        Pounds result = inPounds(0);
        for (Book book : books) result = result.plus(book.getPrice());
        return result;
    }

    public List<Book> getBooks() {
        return books;
    }

    public String getSummary() {
        if (1 == getBookCount()) return "1 item in cart";
        return getBookCount()+ " items in cart";
    }
}
