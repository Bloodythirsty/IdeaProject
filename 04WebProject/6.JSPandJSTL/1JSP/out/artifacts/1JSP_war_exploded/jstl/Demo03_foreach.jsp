<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 我
  Date: 2020/4/3
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>

<%--
foreach：相当于java的for语句
1. 完成重复的操作

				for( int i = 0 ; i < 10 ; i ++){

				}
			2. JSTL属性
				1. `begin`：开始值
				2. `end`：结束值
				3. `var`：临时变量
				4. `step`：步长，var每次增长多少
		2. 遍历容器

				List<User> list;
				for(User u:list){

				}

--%>
<C:forEach begin="1" end="10" var="i" step="2" varStatus="s">
    ${i}&nbsp;${s.index}&nbsp;${s.count}<br>
</C:forEach>

<hr>

<%
    List list = new ArrayList();
    list.add("aaa");
    list.add("bbb");
    list.add("ccc");
    list.add("ddd");
    list.add("eee");
    request.setAttribute("list",list);
%>

<c:forEach items="${requestScope.list}" var="ob" varStatus="s">
    ${ob}  ${s.index} ${s.count}<br>
</c:forEach>

</html>
