package lesson01;

import java.sql.*;

/**
 * @author zkk;
 * @create 2019-11-28;
 */
public class Demo04_getXxx {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        //1.注册
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.获取链接对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1 ?useSSL=false&serverTimezone=GMT","root","123456");
            //3.获取执行对象
            stmt = conn.createStatement();
            //4.sql
            String sql = "select * from stu2";
            //5.执行
            rs = stmt.executeQuery(sql);

            //6.处理结果
            //6.1光标向下移动一行
            rs.next();
            //6.2获取数据
            int rst = rs.getInt(1);
            System.out.println("rst = " + rst);

            while (rs.next()) {
                System.out.println("name:"+rs.getString("name"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
