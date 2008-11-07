package bookshop.web;

import bookshop.BookStoreApplication;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DisplayCatalogueServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookStoreApplication storeApplication = (BookStoreApplication) request.getSession().getAttribute("application");
        request.setAttribute("books", storeApplication.getAllBooks());
        request.setAttribute("page", "list_all_books.jsp");
    }
}
