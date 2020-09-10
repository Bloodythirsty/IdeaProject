package lesson01;

import utils.JDBCutils;

import java.sql.*;
import java.util.Scanner;

/**
 * @author zkk;
 * @create 2019-12-06;
 */
/*
1. 需求：
		- 通过键盘录入用户和密码
		- 判断用户是否登录成功
 	2. sql：

			USE db4;
			CREATE TABLE user(
				id INT PRIMARY KEY AUTO_INCREMENT,
				username VARCHAR(32),
				password VARCHAR(32)
			);
			SELECT * FROM user;
			INSERT INTO user VALUES(NULL,'ZHANG','123');
 */
public class Demo09_eg {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String username = sc.nextLine();
        String password = sc.nextLine();
        System.out.println(Demo09_eg.login2(username,password));
    }

    /*
    写一个方法,用正常statement写
     */
    public static boolean login1(String username, String password){
        if (username == null || password == null) {
            return false;
        }

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        //判断链接数据库是否成功
        try {
            //1.链接数据库(注意修改properties中得database)
            conn = JDBCutils.getConnection();
            //2.执行对象
            stmt = conn.createStatement();
            //3.定义sql
            String sql = "SELECT * FROM user WHERE username = '"+username+"' AND password = '"+password+"' ";
            System.out.println(sql);
            //4.执行
            rs = stmt.executeQuery(sql);
            //5.判断数据集是否为空即可
//            if(rs.next()){
//                return true;
//            }
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCutils.close(conn,stmt,rs);
        }


        return false;
    }

    /*
    写一个方法,用PreparedStatement写
     */
    public static boolean login2(String username, String password){
        if (username == null || password == null) {
            return false;
        }

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        //判断链接数据库是否成功
        try {
            //1.链接数据库(注意修改properties中得database)
            conn = JDBCutils.getConnection();
            //3.定义sql
            String sql = "SELECT * FROM user WHERE username = ? AND password = ? ";
            //2.执行对象
            pstmt = conn.prepareStatement(sql);
            //？赋值
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            //4.执行
            rs = pstmt.executeQuery();
            //5.判断数据集是否为空即可
//            if(rs.next()){
//                return true;
//            }
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCutils.close(conn,pstmt,rs);
        }


        return false;
    }
}
