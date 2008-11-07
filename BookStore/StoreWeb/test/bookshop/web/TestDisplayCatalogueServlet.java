package bookshop.web;

import bookshop.Book;
import bookshop.BookStoreApplication;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import testutil.servlet.StubHttpServletRequest;
import testutil.servlet.StubHttpServletResponse;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;


public class TestDisplayCatalogueServlet {
    private StubHttpServletRequest request;
    private DisplayCatalogueServlet testee;

    @Before
    public void setUp() throws Exception {

        request = new StubHttpServletRequest();
        request.setMethod("GET");
        BookStoreApplication storeApplication = new BookStoreApplication();
        storeApplication.addBook(new Book(1).withTitle("Around the world in 80 days"));
        request.getSession().setAttribute("application", storeApplication);
        testee = new DisplayCatalogueServlet();
    }

    @Test
    public void allBooksAddedToAllBooksRequestAttribute() throws IOException, ServletException {

        testee.service(request.asHttpServletRequest(), new StubHttpServletResponse().asHttpServletResponse());

        //noinspection unchecked
        List<Book> booksInRequest = (List<Book>) request.getAttribute("books");
        assertNotNull(booksInRequest);
        assertEquals(1, booksInRequest.size());
        assertEquals("Around the world in 80 days", booksInRequest.get(0).getTitle());

    }

    @Test
    public void pageAtttributeIsSetToListBooksPage() throws Exception {
        testee.service(request.asHttpServletRequest(), new StubHttpServletResponse().asHttpServletResponse());
        assertEquals("list_all_books.jsp", request.getAttribute("page"));
    }


}

