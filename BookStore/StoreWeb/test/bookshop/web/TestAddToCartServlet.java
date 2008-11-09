package bookshop.web;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import testutil.servlet.StubHttpServletRequest;
import testutil.servlet.StubHttpServletResponse;
import bookshop.BookStoreApplication;
import bookshop.Book;

public class TestAddToCartServlet {
    private StubHttpServletRequest request;
    private AddToCartServlet testee;
    private BookStoreApplication storeApplication;
    private StubHttpServletResponse stubHttpServletResponse;

    @Before
     public void setUp() throws Exception {

         request = new StubHttpServletRequest();
         request.setMethod("POST");
         storeApplication = new BookStoreApplication();
         storeApplication.addBook(new Book(1));
         storeApplication.addBook(new Book(2));
         request.getSession().setAttribute("application", storeApplication);
         testee = new AddToCartServlet();
        stubHttpServletResponse = new StubHttpServletResponse();
    }

    @Test
    public void theSelectedBookIsAddedToTheCart() throws Exception {
        request.addParameter("id", "2");
        testee.service(request.asHttpServletRequest(), stubHttpServletResponse.asHttpServletResponse());
        assertEquals(1, storeApplication.getCart().getBookCount()) ;
    }


    @Test
    public void testRedirectsToCatalogue() throws Exception {
        request.addParameter("id", "2");
        testee.service(request.asHttpServletRequest(), stubHttpServletResponse.asHttpServletResponse());
        assertEquals("catalogue", stubHttpServletResponse.redirectedTo);

    }


}
