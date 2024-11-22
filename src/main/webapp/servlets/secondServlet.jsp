<%--
  Created by IntelliJ IDEA.
  User: jeongjung-il
  Date: 11/20/24
  Time: 1:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Welcome to second servlet</h2>
<p>
    <strong>${message}</strong>
    <a href="${pageContext.request.contextPath}/world.do">바로가기</a>
</p>

</body>
</html>
