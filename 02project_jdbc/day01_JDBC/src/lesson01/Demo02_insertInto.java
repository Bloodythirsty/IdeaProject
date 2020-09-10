package lesson01;

import com.sun.org.apache.bcel.internal.generic.IFEQ;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author zkk;
 * @create 2019-11-27;
 */
//添加一条语句
public class Demo02_insertInto {
    public static void main(String[] args)  {
        Statement stmt = null;
        Connection conn = null;
        try {
            //1.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.获取数据库链接对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1 ?useSSL=false&serverTimezone=GMT", "root", "123456");
            //3.定义sql
            String sql = "INSERT INTO stu2 VALUES(13,'llzzz')";
            //4.获取执行对象
            stmt = conn.createStatement();
            //5.执行sql
            int count = stmt.executeUpdate(sql);
            System.out.println("count = " + count);
            if (count != 0) {
                System.out.println("succeed!");
            } else {
                System.out.println("failed!");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (stmt != null){  //避免空指针异常
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (conn != null){  //避免空指针异常
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
