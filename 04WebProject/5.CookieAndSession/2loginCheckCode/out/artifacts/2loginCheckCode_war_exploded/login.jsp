<%--
  Created by IntelliJ IDEA.
  User: 我
  Date: 2020/3/31
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <style>
        div{
            color: red;
        }
    </style>

    <script>
        window.onload = function () {
            var img = document.getElementById("changeImg");
            img.onclick = function () {
                img.src = "/2loginCheckCode_war_exploded/CheckCodeImg?"+ new Date().getTime();
            }

            var a_img = document.getElementById("changeImgA");
            a_img.onclick = function () {
                img.src = "/2loginCheckCode_war_exploded/CheckCodeImg?"+ new Date().getTime();
            }
        }
    </script>

</head>
<body>
<%--<form action="/2loginCheckCode_war_exploded/CheckCodeLogin" method="get">--%>
<form action="${pageContext.request.contextPath}/CheckCodeLogin" method="get">
    <table>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="username" placeholder="username"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password" placeholder="password"><br></td>
        </tr>
        <tr>
            <td>验证码</td>
            <td><input type="text" name="checkCode" placeholder="checkCode"></td>
            <td><img src="/2loginCheckCode_war_exploded/CheckCodeImg" id="changeImg"></td>
            <td><a href="javascript:void(0);" id="changeImgA">看不清换一张</a></td>
            <!--            1. 超链接先设置不跳转：javascript:void(0);
                            2. 再去onclick跳转图片资源，这样密码账号不会重新刷新
            -->
        </tr>
        <tr>
            <td>登录</td>
            <td><input type="submit" value="login"></td>
        </tr>
    </table>
</form>

    <div><%= request.getAttribute("err_checkCode") == null ? "" : request.getAttribute("err_checkCode") %></div>
    <div><%= request.getAttribute("err_user") == null ? "" : request.getAttribute("err_user") %></div>
</body>
</html>
