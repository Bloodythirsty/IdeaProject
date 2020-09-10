<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/19
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>请求参数的绑定</title>
</head>
<body>
    <a href="params/testParams?username=kk&password=root">请求参数绑定</a>

    <hr>

    <form action="params/beanParams" method="post">
        用户名<input name="username" type="text"><br>
        密码<input name="password" type="text"><br>
        钱<input name="money" type="text"><br>
        账户id<input name="account.accountId" type="text"><br>
        账户名<input name="account.accountName" type="text"><br>

        <h4>list</h4>

        账户id<input name="listAccount[0].accountId" type="text"><br>
        账户名<input name="listAccount[0].accountName" type="text"><br>

        账户id<input name="listAccount[1].accountId" type="text"><br>
        账户名<input name="listAccount[1].accountName" type="text"><br>

        账户id<input name="listAccount[2].accountId" type="text"><br>
        账户名<input name="listAccount[2].accountName" type="text"><br>

        <h4>map</h4>

        账户id<input name="mapAccount['one'].accountId" type="text"><br>
        账户名<input name="mapAccount['one'].accountName" type="text"><br>

        账户id<input name="mapAccount['two'].accountId" type="text"><br>
        账户名<input name="mapAccount['two'].accountName" type="text"><br>

        账户id<input name="mapAccount['three'].accountId" type="text"><br>
        账户名<input name="mapAccount['three'].accountName" type="text"><br>

        <input type="submit" value="登陆">
    </form>
</body>
</html>
