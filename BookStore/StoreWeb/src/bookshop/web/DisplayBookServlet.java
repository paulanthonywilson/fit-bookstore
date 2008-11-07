package bookshop.web;

import bookshop.BookStoreApplication;

import javax.servlet.http.HttpServletRequest;

public class DisplayBookServlet extends BookStoreGetServlet {

    protected String doGet(HttpServletRequest request, BookStoreApplication storeApplication) {
        int bookId = Integer.valueOf(request.getParameter("id"));
        request.setAttribute("book", storeApplication.findBookById(bookId));
        return "display_book.jsp";
    }
}
