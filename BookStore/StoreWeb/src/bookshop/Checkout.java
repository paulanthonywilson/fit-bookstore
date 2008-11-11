package bookshop;

import bookshop.Customer;

public class Checkout {
    private Customer customer = new Customer();
    private CreditCard creditCard = new CreditCard();
    private Cart confirmedOrder;

    public Customer getCustomer() {
        return customer;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public Cart getConfirmedOrder() {
        return confirmedOrder;
    }

    public void setConfirmedOrder(Cart confirmedOrder) {
        this.confirmedOrder = confirmedOrder;
    }
}
