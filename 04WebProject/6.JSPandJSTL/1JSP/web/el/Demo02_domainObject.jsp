<%--
  Created by IntelliJ IDEA.
  User: 我
  Date: 2020/4/2
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el获取域中数据</title>
</head>
<body>

</body>

    <%
        //在域中存储
        request.setAttribute("msg1","hello request");
        session.setAttribute("msg1","hello Session");
        pageContext.setAttribute("msg1","hellow pageContext");      //当前页面共享数据
        application.setAttribute("msg","hellow application");
    %>

    ${pageScope.msg}<br>
    ${requestScope.msg}<br>
    ${sessionScope.msg}<br>
    ${applicationScope.msg}<br>

    <h3>    依次从最小的域中开始查找 pageScope -> request -> session -> application</h3>
    ${msg}<br>

</html>
