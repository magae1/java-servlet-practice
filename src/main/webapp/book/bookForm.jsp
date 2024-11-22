<%--
  Created by IntelliJ IDEA.
  User: campus2H039
  Date: 24. 11. 21.
  Time: 오전 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book Form</title>
</head>
<body>
  <form action="${pageContext.request.contextPath}/book" method="post">
    <label for="bookId">책 아이디 : </label>
    <input type="text" id="bookId" name="bookId">
    <label for="bookName">책 제목 : </label>
    <input type="text" id="bookName" name="bookName">
    <label for="bookId">출판사 : </label>
    <input type="text" id="publisher" name="publisher">
    <label for="bookId">가격 : </label>
    <input type="text" id="price" name="price">
    <input type="submit" value="제출">
  </form>
</body>
</html>
