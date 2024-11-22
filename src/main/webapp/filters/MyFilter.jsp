<%--
  Created by IntelliJ IDEA.
  User: jeongjung-il
  Date: 11/22/24
  Time: 2:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        function formSubmit(form, methodType) {
            if (methodType == 1) {
                form.method = 'get';
            } else if (methodType == 2) {
                form.method = 'post';
            }

            form.submit();
        }
    </script>
</head>
<body>
<h2>web.xml에서 매핑하기</h2>
<form>
    <input type="button" onClick="formSubmit(this.form, 1);" value="Get방식전송"/>
    <input type="button" onClick="formSubmit(this.form, 2);" value="Post방식전송"/>
</form>
</body>
</html>
