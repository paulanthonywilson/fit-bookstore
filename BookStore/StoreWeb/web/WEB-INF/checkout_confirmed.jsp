<%--@elvariable id="application" type="bookshop.BookStoreApplication"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="order_confirmation">
    <h1>Thank you for your order.</h1>

    <p>The order contains the following books:</p>
    <ul>
        <c:forEach items="${application.checkout.confirmedOrder.books}" var="book">
            <li>${book.title} by ${book.author}</li>
        </c:forEach>
    </ul>

    <p>The order will be dispatched to:</p>

    <p>
        ${application.checkout.customer.fullName}<br/>
        ${application.checkout.customer.address}<br/>
        ${application.checkout.customer.address2}<br/>
        ${application.checkout.customer.town}<br/>
        ${application.checkout.customer.postcode}<br/>

    </p>

    <p>£${application.checkout.confirmedOrder.total} will be charged to the credit card
         ${application.checkout.creditCard.maskedNumber}</p>
</div>