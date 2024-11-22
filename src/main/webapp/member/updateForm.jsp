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
  <title>개인정보수정 페이지</title>
</head>
<body>
<form action="/${pageContext.request.contextPath}member/update.action" method="get">
  <h3>개인정보수정</h3>
  <label for="pwd">비밀번호</label>
  <input type="text" name="pwd" id="pwd" value="${member.userPwd}">
  <label for="name">이름</label>
  <input type="text" name="name" id="name" value="${member.userName}">
  <label for="email">이메일</label>
  <input type="text" name="email" id="email" value="${member.email}">
  <label for="email">휴대폰 번호</label>
  <input type="text" name="phoneno" id="phoneno" value="${member.phoneNo}">
  <input type="submit" value="수정하기">
</form>
</body>
</html>
