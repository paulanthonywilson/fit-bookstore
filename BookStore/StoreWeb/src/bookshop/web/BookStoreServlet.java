package bookshop.web;

import bookshop.BookStoreApplication;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class BookStoreServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookStoreApplication storeApplication = (BookStoreApplication) request.getSession().getAttribute("application");

        String page = service(request, response, storeApplication);
        request.setAttribute("page", page);
    }

    protected abstract String service(HttpServletRequest request, HttpServletResponse response, BookStoreApplication storeApplication) throws IOException;
}
