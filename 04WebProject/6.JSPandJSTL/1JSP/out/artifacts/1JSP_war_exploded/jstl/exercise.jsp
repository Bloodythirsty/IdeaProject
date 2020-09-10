<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="kk.User" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/4/7
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>

<%--
    准备数据
--%>
    <%
        List list = new ArrayList<User>();
        list.add(new User("zhang","男",new Date()));
        list.add(new User("xin","女",new Date()));
        list.add(new User("uuuuu","男",new Date()));
        list.add(new User("uuuuu","男",new Date()));
        list.add(new User("uuuuu","男",new Date()));
        list.add(new User("uuuuu","男",new Date()));
        list.add(new User("uuuuu","男",new Date()));

        request.setAttribute("list",list);
    %>

<table border="1" width="500" align="center" cellspacing="0">
    <tr>
        <th>name</th>
        <th>gerder</th>
        <th>bir</th>
    </tr>
    <c:forEach items="${requestScope.list}" var="ob" varStatus="s">
        <c:if test="${ob.gender == '男'}">
            <tr bgcolor="red">
                <td>${ob.name}</td>
                <td>${ob.gender}</td>
                <td>${ob.birStr}</td>
            </tr>
        </c:if>
        <c:if test="${ob.gender == '女'}">
            <tr bgcolor="#fff8dc">
                <td>${ob.name}</td>
                <td>${ob.gender}</td>
                <td>${ob.birStr}</td>
            </tr>
        </c:if>
    </c:forEach>
</table>


</html>
