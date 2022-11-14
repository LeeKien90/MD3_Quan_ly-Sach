<%--
  Created by IntelliJ IDEA.
  User: askih
  Date: 11/9/2022
  Time: 11:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Books</title>
    <style>
        /*table {*/
        /*    border: 1px solid;*/
        /*}*/
    </style>
</head>
<body>
<table border="1px solid">
    <thead>
    <tr>
        <th>Book ID</th>
        <th>Book Name</th>
        <th>Author</th>
        <th>Price</th>
        <th>Status</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
   <tbody>
   <%-- Lấy list Book từ request và hiển thị --%>
   <c:forEach items="${listBooks}" var="book">
        <tr>
            <td>${book.bookId}</td>
            <td>${book.bookName}</td>
            <td>${book.author}</td>
            <td>${book.price}</td>
            <td>${book.bookStatus}
            <c:out value="${book.bookStatus== true ? 'Còn Hàng' : 'Hết Hàng'}"/>
            </td>
            <td><a href="BookServlet?bookId=${book.bookId}&&action=update">Update</a></td>
            <td><a href="BookServlet?bookId=${book.bookId}&&action=delete">Delete</a></td>
        </tr>
   </c:forEach>
   </tbody>
</table>
<a href="views/CreateBooks.jsp">Create Books</a>
</body>
</html>
