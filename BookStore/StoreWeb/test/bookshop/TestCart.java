package bookshop;

import static bookshop.Pounds.inPounds;
import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class TestCart {
    @Test
    public void shouldBeAbleToAddBooksToTheCart() throws Exception {
        Cart testee = new Cart();
        testee.add(new Book(1));
        testee.add(new Book(2));
        assertEquals(2, testee.getBookCount());
    }



    @Test
    public void shouldKeepATotalOfItemsInCart() throws Exception {
        Cart testee = new Cart();
        testee.add(new Book(1).atPrice(inPounds(2.25)));
        testee.add(new Book(2).atPrice(inPounds(2.75)));
        assertEquals(inPounds(5.0), testee.getTotal());
    }

    @Test
    public void shouldHavASummary() throws Exception {
        Cart testee = new Cart();
        assertEquals("0 items in cart", testee.getSummary());
        testee.add(new Book(1));
        assertEquals("1 item in cart", testee.getSummary());
        testee.add(new Book(2));
        assertEquals("2 items in cart", testee.getSummary());
     }


}
