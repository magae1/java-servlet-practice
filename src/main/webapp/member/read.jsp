<%--
  Created by IntelliJ IDEA.
  User: campus2H039
  Date: 24. 11. 21.
  Time: 오후 4:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <h3>userid : ${member.userId}</h3>
  <h3>userpwd : ${member.userPwd}</h3>
  <h3>username : ${member.userName}</h3>
  <h3>phoneno : ${member.phoneNo}</h3>
  <h3>address : ${member.address}</h3>
  <h3>email : ${member.email}</h3>
  <h3>regdate : ${member.regDate}</h3>
  <a href="${pageContext.request.contextPath}/member/updateForm.jsp">수정하기</a>
</body>
</html>
