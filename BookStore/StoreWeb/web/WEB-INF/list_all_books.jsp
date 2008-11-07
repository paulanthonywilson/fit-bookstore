<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%--@elvariable id="books" type="java.util.List"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<c:forEach items="${books}" var="book">
    <div class="book">
        <img src="${book.image}" alt="${book.title}"/>
    </div>
</c:forEach>