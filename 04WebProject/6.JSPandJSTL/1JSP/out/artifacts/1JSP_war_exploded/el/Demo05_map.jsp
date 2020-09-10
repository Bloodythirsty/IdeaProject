<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: 我
  Date: 2020/4/3
  Time: 0:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>map</title>
</head>
<body>

</body>
<%
    Map map = new HashMap();
    map.put("zhang","san");
    map.put("li","si");

    request.setAttribute("map",map);
%>

<h5>map获取</h5>
${requestScope.map.zhang}<br>
${requestScope.map["zhang"]}<br>
${requestScope.map.li}<br>
</html>
