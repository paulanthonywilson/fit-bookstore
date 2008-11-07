package bookshop.web;

import bookshop.Book;
import bookshop.BookStoreApplication;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import testutil.servlet.StubHttpServletRequest;
import testutil.servlet.StubHttpServletResponse;

public class TestDisplayBookServlet {
    private StubHttpServletRequest request;
    private BookStoreGetServlet testee;

    @Before
    public void setUp() throws Exception {

        request = new StubHttpServletRequest();
        request.setMethod("GET");
        BookStoreApplication storeApplication = new BookStoreApplication();
        storeApplication.addBook(new Book(1));
        storeApplication.addBook(new Book(2));
        request.getSession().setAttribute("application", storeApplication);
        testee = new DisplayBookServlet();
    }


    @Test
    public void findsABookThenAddsItToTheRequest() throws Exception {
        request.addParameter("id", "2");
        testee.service(request.asHttpServletRequest(), new StubHttpServletResponse().asHttpServletResponse());
        Book book = (Book) request.getAttribute("book");
        assertNotNull(book);
        assertEquals(2, book.getId());
    }

    @Test
    public void setsThePageParameterToDisplayBookPage() throws Exception {
        request.addParameter("id", "2");
        testee.service(request.asHttpServletRequest(), new StubHttpServletResponse().asHttpServletResponse());
        assertEquals("display_book.jsp", request.getAttribute("page"));
    }


}
