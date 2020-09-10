<%--
  Created by IntelliJ IDEA.
  User: 我
  Date: 2020/4/2
  Time: 20:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>服务器正忙</h1>

</body>
    <%
        System.out.println("服务器正忙");
        String message = exception.getMessage();
        System.out.println("message = " + message);
        out.write(message);
    %>
</html>
