<%@ page import="org.apache.ibatis.io.Resources" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactoryBuilder" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="cn.kk.dao.IRoleDao" %>
<%@ page import="cn.kk.domain.Role" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.InputStream" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactory" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<body>
<h2>Hello World!</h2>




</body>
<%--<%--%>
<%--    //1. 读取配置文件--%>
<%--    InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");--%>
<%--    //2. 根据创建者模式创建工厂--%>
<%--    SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();--%>
<%--    SqlSessionFactory factory = builder.build(in);--%>
<%--    SqlSession sqlSession = factory.openSession();--%>
<%--    // SqlSession sqlSession = factory.openSession(true);    开启自动提交，即关闭事务--%>
<%--    IRoleDao iRoleDao = sqlSession.getMapper(IRoleDao.class);--%>
<%--    List<Role> roles = iRoleDao.findAll();--%>
<%--    for (Role r:roles){--%>
<%--        System.out.println("role = " + r);--%>
<%--    }--%>
<%--%>--%>
</html>
