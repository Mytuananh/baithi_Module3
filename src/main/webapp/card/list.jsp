<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/19/2021
  Time: 2:07 PM
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
    <h1>Cards Management</h1>
    <h3><a href="/Book" >Library</a></h3>
    <table border="1">
        <tr>
            <th>Card Code</th>
            <th>Book</th>
            <th>Author</th>
            <th>Student</th>
            <th>Class</th>
            <th>BorrowDate</th>
            <th>PayDate</th>
            <th>Return</th>
        </tr>
        <c:forEach items="${cardList}" var="card">
            <tr>
                <td>${card.id}</td>
                <td>${card.getBook().nameBook}</td>
                <td>${card.getBook().author}</td>
                <td>${card.getStudent().fullName}</td>
                <td>${card.getStudent().className}</td>
                <td>${card.borrowDate}</td>
                <td>${card.payDate}</td>
                <td><a href="/cards?action=return&id=${card.id}">Return</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
