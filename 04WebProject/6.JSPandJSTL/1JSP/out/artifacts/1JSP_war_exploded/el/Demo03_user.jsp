<%@ page import="kk.User" %>
<%@ page import="java.util.Date" %>
<%--
  Created by IntelliJ IDEA.
  User: 我
  Date: 2020/4/2
  Time: 22:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取对象数据</title>
</head>
<body>

</body>
<%
    User user = new User();
    user.setName("zhangsan");
    user.setGender("男");
    user.setBir(new Date());

    request.setAttribute("user",user);
%>

<h3> 使用el表达式，获取对象值</h3>
${requestScope.user}<br>
<h5>
    通过对象的属性来获取,即setter和getter去掉set和get后，将首字母变小写<br>
        即：setName 的属性是 name<br>
        与BeanUtils.setProperty(bean,name,value)中的name一样<br>
</h5>
${requestScope.user.name}<br>
${requestScope.user.gender}<br>
${requestScope.user.bir}<br>

<h5> 通过定义一个getter来实现另外的功能，例如格式化bir</h5>
${requestScope.user.birStr}<br>

</html>
