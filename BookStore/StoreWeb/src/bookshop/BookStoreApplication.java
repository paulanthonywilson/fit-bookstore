package bookshop;

import java.util.ArrayList;
import java.util.List;

public class BookStoreApplication {
    private List<Book> allBooks = new ArrayList<Book>();
    private Cart cart = new Cart();
    private Checkout checkout = new Checkout();

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


    public Cart getCart() {
        return cart;
    }

    public Checkout getCheckout() {
        return checkout;
    }

    public void addBookToCart(int id) {
        cart.add(findBookById(id));
    }

    public void confirmOrder() {
        checkout.setConfirmedOrder(cart);
        cart = new Cart();
    }
}
