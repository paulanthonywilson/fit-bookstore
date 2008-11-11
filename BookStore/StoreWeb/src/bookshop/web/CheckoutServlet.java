package bookshop.web;

import bookshop.BookStoreApplication;
import bookshop.Customer;
import bookshop.CreditCard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CheckoutServlet extends BookStoreServlet {
    protected String service(HttpServletRequest request, HttpServletResponse response, BookStoreApplication storeApplication) throws IOException {
        if ("GET".equals(request.getMethod())) return doGet(request, storeApplication);
        return doPost(request, response, storeApplication);
    }

    private String doPost(HttpServletRequest request, HttpServletResponse response, BookStoreApplication storeApplication) throws IOException {
        Customer customer = storeApplication.getCheckout().getCustomer();
        setCustomer(request, customer);
        setCreditCard(request, storeApplication);
        storeApplication.confirmOrder();
        response.sendRedirect("checkout_confirmed");

        return null;
    }

    private void setCreditCard(HttpServletRequest request, BookStoreApplication storeApplication) {
        CreditCard creditCard = storeApplication.getCheckout().getCreditCard();
        creditCard.setExpiry(request.getParameter("credit_card_expiry"));
        creditCard.setNumber(request.getParameter("credit_card_number"));
        creditCard.setSecurityCode(request.getParameter("credit_card_security_code"));
    }

    private void setCustomer(HttpServletRequest request, Customer customer) {
        customer.setAddress(request.getParameter("address"));
        customer.setAddress2(request.getParameter("address2"));
        customer.setEmail(request.getParameter("email"));
        customer.setFullName(request.getParameter("fullName"));
        customer.setPostcode(request.getParameter("postcode"));
        customer.setTown(request.getParameter("town"));
    }

    private String doGet(HttpServletRequest request, BookStoreApplication storeApplication) {
        request.setAttribute("checkout", storeApplication.getCheckout());
        request.setAttribute("cart", storeApplication.getCart());
        return "checkout_form.jsp";
    }
}
