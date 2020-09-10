<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 我
  Date: 2020/4/2
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    ${ 3 > 4}   <%-- 直接返回false显示 --%>
    \${ 3 > 5}
    <hr>
    <%--
    1. 运算符：
			- 算数运算符：`+ - * / %`
			- 比较运算符：`> >= < <= == !=`
			- 逻辑运算符：`&&(and) ||(or) !(not)`
			- 空运算符：`empty`
    --%>
    <h3>算数</h3>
    ${3 - 5}<br>
    ${3 / 4}<br>
    ${3 div 4}<br>
    ${3 % 4}<br>
    ${3 mod 4}<br>
    <h3>比较运算符</h3>
    ${3 == 4}<br>
    <h3>逻辑</h3>
    ${3 == 4  &&  3 < 4}<br>
    ${3 < 4  and  3 < 4}<br>

    <h3>empty运算符</h3>
    <%
        String str = "abc";
        String str1 = null;
        String str2 = "";
        request.setAttribute("str",str);
        request.setAttribute("str1",str1);
        request.setAttribute("str2",str2);

        List list = new ArrayList<String>();
        list.add("abc");
        list.add("def");
        list.add("ghi");
        request.setAttribute("list",list);
    %>
    <h5>字符串</h5>
    empty<br>
    ${empty str}<br>
    ${empty str1}<br>
    ${empty str2}<br>
    not empty<br>
    ${not empty str}<br>
    ${not empty str1}<br>
    ${not empty str2}<br>

    <h5>list集合</h5>
    ${empty list}<br>


    <h3>从Demo02获取数据</h3>
    ${pageScope.msg}<br>        <%-- 获取不了，作用范围是Demo02 --%>
    ${requestScope.name}<br>    <%-- 获取不了，没有转发 --%>
    ${sessionScope.msg}<br>
    ${applicationScope.msg}<br>
</body>
</html>
