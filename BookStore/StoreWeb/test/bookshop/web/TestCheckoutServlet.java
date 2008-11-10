package bookshop.web;

import bookshop.BookStoreApplication;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import testutil.servlet.StubHttpServletRequest;
import testutil.servlet.StubHttpServletResponse;

public class TestCheckoutServlet {
    private StubHttpServletRequest request;
    private CheckoutServlet testee;
    private StubHttpServletResponse response;

    @Before
    public void setUp() throws Exception {

        request = new StubHttpServletRequest();
        request.getSession().setAttribute("application", new BookStoreApplication());
        response = new StubHttpServletResponse();
        testee = new CheckoutServlet();
    }

    @Test
    public void shouldShowCheckoutFormPageIfRequestMethodIsGet() throws Exception {
        request.setMethod("GET");
        testee.service(request.asHttpServletRequest(), response.asHttpServletResponse());
        assertEquals("checkout_form.jsp", request.getAttribute("page"));
    }




}
