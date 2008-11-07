package bookshop.web;

import bookshop.BookStoreApplication;

import javax.servlet.http.HttpServletRequest;

public class DisplayCatalogueServlet extends BookStoreGetServlet{
  
    protected String doGet(HttpServletRequest request, BookStoreApplication storeApplication) {
        request.setAttribute("books", storeApplication.getAllBooks());
        return "list_all_books.jsp";
    }
}
