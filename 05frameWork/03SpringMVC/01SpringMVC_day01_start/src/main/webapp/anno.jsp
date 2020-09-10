<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/20
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>anno</title>
</head>
<body>

    <a href="params/testRequestParam?name=哈哈">testRequestParam</a>

<hr>

    <form action="params/testRequestBody" method="get">
        账号<input type="text" name="username">
        密码<input type="text" name="password">
        <input type="submit" value="登陆">
    </form>

    <hr>

    <a href="params/testPathVariable/10">PathVariable</a>

    <hr>

    <a href="params/testRequestHeader">RequestHeader</a>

    <hr>

    <a href="params/testCookieValue">CookieValue</a>


    <hr>

    <form action="params/testModelAttribute" method="get">
        姓名<input type="text" name="name">
        性别<input type="text" name="sex">
        <input type="submit" value="ModelAttribute登陆">
    </form>

    <hr>

    <a href="params/testSessionAttributes">SessionAttribute</a>

    <hr>

    <a href="params/getSessionAttributes">GetSessionAttribute</a>

    <hr>

    <a href="params/removeRequestAttribute">removeRequestAttribute</a>

    <hr>

    <a href="params/removeSessionAttribute">removeSessionAttribute</a>

</body>
</html>
