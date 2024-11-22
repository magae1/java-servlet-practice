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
  <form action="/${pageContext.request.contextPath}member/join.action" method="get">
    <h3>회원 가입 정보</h3>
    <label for="id">아이디</label>
    <input type="text" name="id" id="id">
    <label for="pwd">비밀번호</label>
    <input type="text" name="pwd" id="pwd">
    <label for="name">이름</label>
    <input type="text" name="name" id="name">
    <label for="email">이메일</label>
    <input type="text" name="email" id="email">
    <input type="submit" value="가입하기">
  </form>
</body>
</html>
