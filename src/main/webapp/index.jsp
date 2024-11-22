<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %></h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<a href="other-servlet">Other Servlet</a>
<a href="world.do">World Servlet</a>
<form action="${pageContext.request.contextPath}/welcome.do" method="GET">
  아이디: <input type="text" name="id"/><br/>
  비밀번호: <input type="text" name="pwd"/><br/>
  <input type="submit" value="전송"/>
</form>
<form action="${pageContext.request.contextPath}/portal.do">
  <input type="radio" name="site" value="naver">네이버<br />
  <input type="radio" name="site" value="google">구글<br />
  <input type="submit" value="이동" />
</form>
</body>
</html>