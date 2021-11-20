<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/19/2021
  Time: 2:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
  <table>
    <tr>
      <td>Book:</td>
      <td><input type="text" hidden>${book.nameBook}</td>
    </tr>
    <tr>
      <td>Students</td>
      <td>
        <select name="student" id="student">
          <c:forEach items="${studentList}" var="student">
            <option value="${student.sId}">${student.fullName}</option>
          </c:forEach>
        </select>
      </td>
    </tr>
    <tr>
      <td>BorrowDate</td>
      <td><input type="text" name="borrowDate"  placeholder="dd/mm/yyy"></td>
    </tr>
    <tr>
      <td>PayDate</td>
      <td><input type="text" name="payDate"  placeholder="dd/mm/yyy"></td>
    </tr>
    <tr>
      <td></td>
      <td><input type="submit" value="Borrow"></td>
    </tr>
  </table>
</form>
</body>
</html>
