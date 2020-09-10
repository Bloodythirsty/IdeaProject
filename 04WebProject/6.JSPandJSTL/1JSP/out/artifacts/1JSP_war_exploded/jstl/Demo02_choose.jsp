<%--
  Created by IntelliJ IDEA.
  User: 我
  Date: 2020/4/3
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>choose</title>
</head>
<body>

</body>

<h5>完成星期几案例</h5>
<%--
    分析
        1. 在域中存储一个数字
        2. 用choose标签取出数字                相当于switch声明
        3. 用when标签做判断                    相当于case
        4. otherwise标签做其他情况声明         相当于default
    --%>

    <%
        request.setAttribute("week",1);

    %>
    <c:choose>
        <c:when test="${requestScope.week == 1}">Monday</c:when>
        <c:when test="${requestScope.week == 2}">Tuesday</c:when>
        <c:when test="${requestScope.week == 3}">wednesday</c:when>
        <c:when test="${requestScope.week == 4}">Thursday</c:when>
        <c:when test="${requestScope.week == 5}">Friday</c:when>
        <c:when test="${requestScope.week == 6}">Saturday</c:when>
        <c:when test="${requestScope.week == 7}">Sunday</c:when>
        <c:otherwise>数字输入有误</c:otherwise>
    </c:choose>
</html>
