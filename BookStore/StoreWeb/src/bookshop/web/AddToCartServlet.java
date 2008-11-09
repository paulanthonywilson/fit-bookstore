package bookshop.web;

import bookshop.Book;
import bookshop.BookStoreApplication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddToCartServlet extends BookStoreServlet {

    protected String service(HttpServletRequest request, HttpServletResponse response, BookStoreApplication storeApplication) throws IOException {
        Book book = storeApplication.findBookById(Integer.valueOf(request.getParameter("id")));
        storeApplication.getCart().add(book);
        response.sendRedirect("catalogue");
        return null;
    }
}
