<%--
  Created by IntelliJ IDEA.
  User: 我
  Date: 2020/3/28
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
        <%
          System.out.println("hello JSP");
            int i = 5;
        %>

        <%!
            int i = 3;
        %>

        <%=
            i
        %>
        <%=
            "woshiainide"
        %>
        <h1>hello jsp</h1>
</body>
</html>
