<%--@elvariable id="application" type="bookshop.BookStoreApplication"--%>
<%--@elvariable id="page" type="java.lang.String"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
    <title>Book store</title>
    <link href="/css/reset-fonts-grids.css" type="text/css" media="screen" rel="stylesheet"/>

    <link href="/css/bookstore.css" type="text/css" rel="stylesheet" media="screen"/>
</head>
<body>
<div id="cart">
    <p><a href="/store/displaycart">${application.cart.summary}</a> </p>
</div>
<div id="page">
    <jsp:include page="${page}"/>
</div>
</body>
</html>