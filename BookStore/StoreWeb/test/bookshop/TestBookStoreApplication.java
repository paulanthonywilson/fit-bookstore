package bookshop;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import static java.util.Arrays.asList;

public class TestBookStoreApplication {
    private BookStoreApplication testee;

    @Before
    public void setUp() throws Exception {
        testee = new BookStoreApplication();
        testee.addBook(new Book(1));
        testee.addBook(new Book(2));
    }

    @Test
    public void shouldBeAbleToFindABookById() throws Exception {
        assertEquals(1, testee.findBookById(1).getId());
        assertEquals(2, testee.findBookById(2).getId());
    }


    @Test(expected = BookNotFoundException.class)
    public void notFindingABookCausesBookNotFoundException() throws Exception {
       testee.findBookById(3);

    }

    @Test
    public void addBookToCart() throws Exception {
        testee.addBookToCart(1);
        assertEquals(1, testee.getCart().getBookCount());
        assertEquals(asList(testee.findBookById(1)), testee.getCart().getBooks());
    }

    @Test
    public void confirmingOrderEmptiesCart() throws Exception {
        testee.addBookToCart(2);
        testee.confirmOrder();
        assertEquals(0, testee.getCart().getBookCount());
        assertEquals(asList(testee.findBookById(2)), testee.getCheckout().getConfirmedOrder().getBooks());

    }


}
