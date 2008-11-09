package bookshop.web;

import bookshop.BookStoreApplication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DisplayBookServlet extends BookStoreServlet {

    protected String service(HttpServletRequest request, HttpServletResponse response, BookStoreApplication storeApplication) {
        int bookId = Integer.valueOf(request.getParameter("id"));
        request.setAttribute("book", storeApplication.findBookById(bookId));
        return "display_book.jsp";
    }
}
