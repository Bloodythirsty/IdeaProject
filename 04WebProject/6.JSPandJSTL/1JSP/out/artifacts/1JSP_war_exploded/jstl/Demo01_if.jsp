<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 我
  Date: 2020/4/3
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


</body>
<%--
1. `test`：必须属性，接受boolean表达式
				- true：显示if标签体内容
				- false：不显示标签体
--%>

    <c:if test="true">
        测试 if，test=true
    </c:if>

    <h5>一般结合el表达式，比如：判断list不为空，然后遍历</h5>
    <%
        List list = new ArrayList<String>();
        list.add("zhang");
        list.add("kang");
        list.add("hui");
        request.setAttribute("list",list);
    %>

    <c:if test="${not empty requestScope.list}">
        list不为空
    </c:if>
</html>
