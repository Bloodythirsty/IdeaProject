<%--
  Created by IntelliJ IDEA.
  User: ��
  Date: 2020/4/2
  Time: 19:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  $END$

  </body>
  <%
    pageContext.setAttribute("msg","hello pageContext");
  %>

  <%
    String msg = (String)pageContext.getAttribute("msg");
    out.write(msg);
  %>

</html>
