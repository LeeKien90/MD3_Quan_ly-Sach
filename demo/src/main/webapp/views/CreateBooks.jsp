<%--
  Created by IntelliJ IDEA.
  User: askih
  Date: 11/10/2022
  Time: 8:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Books</title>
</head>
<body>
<h1>Create Book</h1>
<form action="<%=request.getContextPath()%>/BookServlet" method="post">
  <table border="1px solid">
    <tr>
      <th>Book ID</th>
      <td colspan="2"><input type="text" name="bookId"></td>
    </tr>
    <tr>
      <th>Book Name</th>
      <td colspan="2"><input type="text" name="bookName"></td>
    </tr>
    <tr>
      <th>Author</th>
      <td colspan="2"><input type="text" name="author"></td>
    </tr>
    <tr>
      <th>Price</th>
      <td colspan="2"><input type="text" name="price"></td>
    </tr>
    <tr>
      <th>Status</th>
      <td><input type="radio" value="true">Còn hàng</td>
      <td><input type="radio" value="false">Hết hàng</td>
    </tr>
    <tr>
      <%--    <button>Create Book</button>--%>
      <td colspan="3" align="center"><input type="submit" value="Create" name="action"></td>
    </tr>
  </table>
</form>

<a href="<%=request.getContextPath()%>/BookServlet">Trở lại</a>
</body>
</html>
