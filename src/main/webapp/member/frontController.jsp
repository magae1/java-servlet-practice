<%--
  Created by IntelliJ IDEA.
  User: campus2H039
  Date: 24. 11. 21.
  Time: 오후 1:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Front Controller</title>
</head>
<body>
  <h1>frontController</h1>
  <ul>
  <li><a href="${pageContext.request.contextPath}/member/loginForm.jsp">로그인</a></li><hr/>
  <li><a href="${pageContext.request.contextPath}/member/joinForm.jsp">회원 가입</a></li><hr/>
  <li><a href="${pageContext.request.contextPath}/member/read.action">회원 조회</a></li><hr/>
  <li><a href="${pageContext.request.contextPath}/member/updateForm.jsp">회원정보 수정</a></li><hr/>
  <li><a href="${pageContext.request.contextPath}/member/delete.action">회원 삭제</a></li><hr/>
  <li><a href="${pageContext.request.contextPath}/member/list.action">모든 회원 보기</a></li><hr/>
  </ul>
</body>
</html>
