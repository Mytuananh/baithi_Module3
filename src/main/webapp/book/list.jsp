<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/19/2021
  Time: 1:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <h1><a href="/Book">Book management</a></h1>
    <h3>Create new Book</h3>
    <table border="1" >
        <tr>
            <th>Name</th>
            <th>Author</th>
            <th>Description</th>
            <th>Quantity</th>
            <th>Borrow</th>
        </tr>
        <c:forEach items="${bookList}" var="book">
            <tr>
                <td>${book.nameBook}</td>
                <td>${book.author}</td>
                <td>${book.description}</td>
                <td>${book.quantity}</td>
                <td><a href="/cards?action=create&id=${book.bId}">Borrow</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
