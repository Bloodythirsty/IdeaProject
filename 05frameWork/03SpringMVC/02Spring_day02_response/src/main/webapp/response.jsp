<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/21
  Time: 12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script src="js/jquery-3.3.1.min.js"></script>
    <script>
        $(function () {
            $("#btn").click(function () {
                alert("hello");
                $.ajax({
                    url:"user/testAjax",
                    contentType:"application/json;charset=UTF-8",
                    data:'{"name":"hehe", "sex":"nan", "age":11}',
                    dataType:"json",
                    type:"post",
                    success:function(date) {
                        alert(date);
                        alert(date.name);
                    }
                });
            });
        });
    </script>
</head>
<body>

    <a href="user/testString"> testString </a>
    <hr>

    <a href="user/testVoid"> tesVoid </a>
    <hr>

    <a href="user/testModelAndView"> testModelAndView </a>
    <hr>

    <a href="user/testForwardOrRedirect"> testForwardOrRedirect </a>
    <hr>

    <button id="btn">发送ajax</button>

</body>
</html>
