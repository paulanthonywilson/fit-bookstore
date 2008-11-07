package bookshop.web;

import bookshop.BookStoreApplication;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class BookStoreGetServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookStoreApplication storeApplication = (BookStoreApplication) request.getSession().getAttribute("application");

        String page = doGet(request, storeApplication);
        request.setAttribute("page", page);
    }

    protected abstract String doGet(HttpServletRequest request, BookStoreApplication storeApplication);
}
