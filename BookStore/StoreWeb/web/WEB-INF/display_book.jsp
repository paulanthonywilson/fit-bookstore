<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%--@elvariable id="book" type="bookshop.Book"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<a href="catalogue">Return to list of books</a>

<div class="displaybook">
<img class="book" src="${book.image}" alt="${book.title}"/>
<h1>${book.title}</h1>
<p class="description">${book.description}</p>
<p class="price">Price: <em>£${book.price}</em></p>
<form action="/store/addtocart" method="POST">
    <input type="hidden" name="id" value="${book.id}"/>
    <input type="submit" value="add to cart"/>
</form>
</div>