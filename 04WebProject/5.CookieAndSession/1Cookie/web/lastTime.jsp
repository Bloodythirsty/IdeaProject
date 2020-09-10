<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.io.UnsupportedEncodingException" %>
<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.net.URLEncoder" %><%--
  Created by IntelliJ IDEA.
  User: 我
  Date: 2020/3/29
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%!
        private void nextVisit(PrintWriter writer, Cookie ck, HttpServletResponse response) throws UnsupportedEncodingException {
            //解码,取出来先解码
            String decode = URLDecoder.decode(ck.getValue(), "utf-8");
            System.out.println("url解码后 next = " + decode);
            writer.write("欢迎再次回来，您上次的访问时间为：" + decode);

            String str_date = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(new Date());
            //编码
            System.out.println("url编码前 next = " + str_date);
            String encode = URLEncoder.encode(str_date, "UTF-8");
            System.out.println("url编码后 next = " + encode);
            ck.setValue(encode);
            response.addCookie(ck);
        }

        private void firstVisit(HttpServletResponse response, PrintWriter writer) throws UnsupportedEncodingException {
            writer.write("欢迎首次访问！");
            String str_date = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(new Date());

            System.out.println("url编码前 first = " + str_date);
            // URL编码
            String encode = URLEncoder.encode(str_date, "UTF-8");
            System.out.println("url编码后 first = " + encode);


            Cookie lastTimeCookie = new Cookie("lastTime",encode);
            response.addCookie(lastTimeCookie);
        }
    %>

    <%
        //1. 获取所有cookie，判断是否有lastTime的cookie
        Cookie[] cookies = request.getCookies();
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        boolean flag = false;
        if ( cookies != null && cookies.length > 0){
            for (Cookie ck: cookies
            ) {
                //存在其他cookie的情况下，如果有lastTime的Cookie
                if ( ck.getName().equals("lastTime")){
                    flag = true;
                    nextVisit(writer, ck,response);
                    //    System.exit(1);       思路，找到结束程序。但这样会结束服务器。
                }
                //存在其他cookie的情况下，如果没有lastTime的Cookie。
                //但如果要找的cookie在后面，前面几次就会多次添加同一个cookie，不可取
//                else {
//                    firstVisit(response, writer);
//                }
            }
        }
        //cookies为空，或者 没找到，
        if ( cookies == null || cookies.length==0 || !flag){
            firstVisit(response, writer);
        }
    %>

</body>
</html>
