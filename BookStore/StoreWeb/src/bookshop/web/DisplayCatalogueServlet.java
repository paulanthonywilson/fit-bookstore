package bookshop.web;

import bookshop.BookStoreApplication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DisplayCatalogueServlet extends BookStoreServlet {
  
    protected String service(HttpServletRequest request, HttpServletResponse response, BookStoreApplication storeApplication) {
        request.setAttribute("books", storeApplication.getAllBooks());
        return "list_all_books.jsp";
    }
}
