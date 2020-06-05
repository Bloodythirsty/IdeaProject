package lesson01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author zkk;
 * @create 2019-11-28;
 */
public class Demo03_update {
    public static void main(String[] args) {
        Connection conn =null;
        Statement stmt = null;
        try {
            //1.注册
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.获取链接对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1 ?useSSL=false&serverTimezone=GMT", "root", "123456");
            //3.获取执行对象
            stmt = conn.createStatement();
            //4. sql语句
            String sql = "UPDATE stu2 SET name = 'xinqing' Where id=13";
            //5.执行
            int count = stmt.executeUpdate(sql);
            System.out.println("count = " + count);
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
        }


    }
}
