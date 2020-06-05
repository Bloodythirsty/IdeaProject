package lesson01;

import utils.JDBCutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author zkk;
 * @create 2019-12-07;
 */
public class Demo10_commit {
    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;

        try {
            //1.获取链接对象
            conn = JDBCutils.getConnection();

            //开启事务
            conn.setAutoCommit(false);

            //2.写sql
            //张三+500
            String sql1 = "UPDATE account SET balance = balance + ? WHERE id = ?";
            //李四-500
            String sql2 = "UPDATE account SET balance = balance - ? WHERE id = ?";
            //3.获取执行对象
            pstmt1 = conn.prepareStatement(sql1);
            pstmt2 = conn.prepareStatement(sql2);
            //4.设置参数
            pstmt1.setInt(1,500);
            pstmt1.setInt(2,1);

            pstmt2.setInt(1,500);
            pstmt2.setInt(2,2);
            //5.执行
            pstmt1.executeUpdate();
            //制造异常，则转帐不正确
            //int a = 10/0;
            pstmt2.executeUpdate();

            //最后没问题，提交事务
            conn.commit();

        } catch (SQLException e) {
            //出异常，进行回滚
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            JDBCutils.close(conn,pstmt1);
            JDBCutils.close(null,pstmt2);
        }


    }
}
