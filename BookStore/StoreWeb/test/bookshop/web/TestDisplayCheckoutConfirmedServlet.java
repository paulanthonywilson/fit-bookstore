package bookshop.web;

import bookshop.BookStoreApplication;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import testutil.servlet.StubHttpServletRequest;
import testutil.servlet.StubHttpServletResponse;

public class TestDisplayCheckoutConfirmedServlet {
    private StubHttpServletRequest request;
    private DisplayCheckoutConfirmedServlet testee;

    @Before
    public void setUp() throws Exception {

        request = new StubHttpServletRequest();
        request.setMethod("GET");
        request.getSession().setAttribute("application", new BookStoreApplication());
        testee = new DisplayCheckoutConfirmedServlet();
    }

    @Test
    public void shouldDisplayConfirmedPage() throws Exception {
        testee.service(request.asHttpServletRequest(), new StubHttpServletResponse().asHttpServletResponse());
        assertEquals("checkout_confirmed.jsp", request.getAttribute("page"));
    }


}
