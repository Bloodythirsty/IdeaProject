<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/28
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>success</title>
</head>
<body>
    <h3>success！</h3>
<hr>
    <c:forEach items="${requestScope.accounts}" var="account" varStatus="s">
        ${account} <br>
    </c:forEach>
</body>
</html>
