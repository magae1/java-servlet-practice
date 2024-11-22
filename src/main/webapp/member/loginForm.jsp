<%--
  Created by IntelliJ IDEA.
  User: campus2H039
  Date: 24. 11. 21.
  Time: 오후 5:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<form action="/${pageContext.request.contextPath}member/login.action">
  <h3>로그인 정보</h3>
  <label for="id">아이디</label>
  <input type="text" name="id" id="id">
  <label for="pwd">비밀번호</label>
  <input type="text" name="pwd" id="pwd">
  <input type="submit" value="로그인">
</form>
</body>
</html>
