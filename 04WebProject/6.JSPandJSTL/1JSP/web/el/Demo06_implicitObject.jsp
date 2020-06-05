<%--
  Created by IntelliJ IDEA.
  User: 我
  Date: 2020/4/3
  Time: 0:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>implicitObject</title>
</head>
<body>

</body>
    ${pageContext.request}<br>
    <h5>动态获取虚拟目录</h5>
    ${pageContext.request.contextPath}<br>
<%
    String contextPath = request.getContextPath();
    out.write(contextPath);

%>
</html>
