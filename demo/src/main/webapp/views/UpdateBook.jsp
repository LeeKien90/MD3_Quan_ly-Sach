<%--
  Created by IntelliJ IDEA.
  User: askih
  Date: 11/10/2022
  Time: 8:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Book</title>
    <style>

    </style>
</head>
<body>
<h1>Update Book</h1>
<form action="<%=request.getContextPath()%>/BookServlet" method="post">
    <table border="1px solid">
        <tr>
            <th>Book ID</th>
            <td colspan="2"><input type="text" name="bookId" value="${bookUpdate.bookId}" readonly></td>
        </tr>
        <tr>
            <th>Book Name</th>
            <td colspan="2"><input type="text" name="bookName" value="${bookUpdate.bookName}"></td>
        </tr>
        <tr>
            <th>Author</th>
            <td colspan="2"><input type="text" name="author" value="${bookUpdate.author}"></td>
        </tr>
        <tr>
            <th>Price</th>
            <td colspan="2"><input type="text" name="price" value="${bookUpdate.price}"></td>
        </tr>
        <tr>
            <th>Status</th>
            <td><input type="radio" value="${bookUpdate.bookStatus}">Còn Hàng</td>
            <td><input type="radio" value="${bookUpdate.bookStatus}">Hết Hàng</td>
        </tr>
        <tr>
            <td colspan="3" align="center"><input type="submit" value="Update" name="action"></td>
        </tr>
    </table>
</form>

<a href="<%=request.getContextPath()%>/BookServlet">Trở lại</a>
</body>
</html>
