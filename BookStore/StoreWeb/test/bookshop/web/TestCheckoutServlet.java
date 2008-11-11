package bookshop.web;

import bookshop.BookStoreApplication;
import bookshop.CreditCard;
import bookshop.Customer;
import bookshop.Book;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import testutil.servlet.StubHttpServletRequest;
import testutil.servlet.StubHttpServletResponse;

import java.util.Arrays;

public class TestCheckoutServlet {
    private StubHttpServletRequest request;
    private CheckoutServlet testee;
    private StubHttpServletResponse response;
    private BookStoreApplication bookStoreApplication;

    @Before
    public void setUp() throws Exception {

        request = new StubHttpServletRequest();
        bookStoreApplication = new BookStoreApplication();
        bookStoreApplication.addBook(new Book(1));
        
        request.getSession().setAttribute("application", bookStoreApplication);
        response = new StubHttpServletResponse();
        testee = new CheckoutServlet();
    }

    @Test
    public void shouldShowCheckoutFormPageIfRequestMethodIsGet() throws Exception {
        request.setMethod("GET");
        testee.service(request.asHttpServletRequest(), response.asHttpServletResponse());
        assertEquals(bookStoreApplication.getCheckout(), request.getAttribute("checkout"));
        assertEquals(bookStoreApplication.getCart(), request.getAttribute("cart"));
        assertEquals("checkout_form.jsp", request.getAttribute("page"));
    }

    @Test
    public void populatesCustomerFieldsForRequestParameterPost() throws Exception {
        request.setMethod("PUT");
        request.addParameter("fullName", "Le Marquis de Carabas")
               .andParameter("email", "carabas@perrault.com")
               .andParameter("address", "Ogre's Castle")
               .andParameter("address2", "Beyond fields")
               .andParameter("town", "Ogreton")
               .andParameter("postcode", "CA1 80T");
        testee.service(request.asHttpServletRequest(), response.asHttpServletResponse());
        Customer customer = bookStoreApplication.getCheckout().getCustomer();
        assertEquals("Le Marquis de Carabas", customer.getFullName());
        assertEquals("carabas@perrault.com", customer.getEmail());
        assertEquals("Ogre's Castle", customer.getAddress());
        assertEquals("Beyond fields", customer.getAddress2());
        assertEquals("Ogreton", customer.getTown());
        assertEquals("CA1 80T", customer.getPostcode());
    }

    @Test
    public void populatesCreditCardFieldsForRequestParameterPost() throws Exception {
        request.setMethod("PUT");
        request.addParameter("credit_card_number", "1234567890123456")
               .andParameter("credit_card_security_code", "123")
               .andParameter("credit_card_expiry", "0112");
        testee.service(request.asHttpServletRequest(), response.asHttpServletResponse());
        CreditCard card = bookStoreApplication.getCheckout().getCreditCard();
        assertEquals("1234567890123456", card.getNumber());
        assertEquals("123", card.getSecurityCode());
        assertEquals("0112", card.getExpiry());

    }

    @Test
    public void redirectsToConfirmationOnSuccessfulPost() throws Exception {
        fullyPopulateRequestWithPost();
        testee.service(request.asHttpServletRequest(), response.asHttpServletResponse());
        assertEquals("checkout_confirmed", response.redirectedTo);
    }

    @Test
    public void orderConfirmed() throws Exception {
        bookStoreApplication.addBookToCart(1);

        fullyPopulateRequestWithPost();
        testee.service(request.asHttpServletRequest(), response.asHttpServletResponse());
        assertEquals(0, bookStoreApplication.getCart().getBookCount());
        assertEquals(1, bookStoreApplication.getCheckout().getConfirmedOrder().getBookCount());

    }


    private void fullyPopulateRequestWithPost() {
        request.setMethod("PUT");
         request.addParameter("fullName", "Le Marquis de Carabas")
                .andParameter("email", "carabas@perrault.com")
                .andParameter("address", "Ogre's Castle")
                .andParameter("address2", "Beyond fields")
                .andParameter("town", "Ogreton")
                .andParameter("postcode", "CA1 80T")
                .andParameter("credit_card_number", "1234567890123456")
                .andParameter("credit_card_security_code", "123")
                .andParameter("credit_card_expiry", "0112");


    }


}
