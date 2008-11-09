package bookshop.web;

import bookshop.BookStoreApplication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DisplayCartServlet extends BookStoreServlet{
    protected String service(HttpServletRequest request, HttpServletResponse response, BookStoreApplication storeApplication) throws IOException {
        return "display_cart.jsp";
    }
}
