<%--@elvariable id="application" type="bookshop.BookStoreApplication"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<a href="/store/catalogue">Return to list of books</a>

<h1>Cart</h1>

<table class="cart">
    <thead>
        <th>Book</th>
        <th>Author</th>
        <th>Price (£)</th>
    </thead>
    <c:forEach items="${application.cart.books}" var="book">
        <tr>
            <td class="title">${book.title}</td>
            <td class="author">${book.author}</td>
            <td class="price">${book.price}</td>
        </tr>
    </c:forEach>
    <tr class="total">
        <td colspan="2" class="total_description">Total</td>
        <td class="total">${application.cart.total}</td>
    </tr>
</table>