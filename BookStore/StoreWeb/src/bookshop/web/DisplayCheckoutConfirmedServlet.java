package bookshop.web;

import bookshop.BookStoreApplication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DisplayCheckoutConfirmedServlet extends BookStoreServlet{
    protected String service(HttpServletRequest request, HttpServletResponse response, BookStoreApplication storeApplication) throws IOException {
        return "checkout_confirmed.jsp";
    }
}
