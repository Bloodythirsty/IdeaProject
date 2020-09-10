<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 我
  Date: 2020/4/2
  Time: 23:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取LIST集合</title>
</head>
<body>

</body>
<%
    List list = new ArrayList<String>();
    list.add("zhang");
    list.add("kang");
    list.add("xin");
    list.add("qing");

    request.setAttribute("list",list);
%>

<h5>通过el获取list</h5>
${requestScope.list[1]}<br>
${requestScope.list}
${requestScope.list[10]}
</html>
