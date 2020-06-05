package druid;

import utils.JDBCutils;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author zkk;
 * @create 2019-12-07;
 */
public class Demo02_testUtils {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt =null;

        try {
            //1.获取链接
            conn = JDBCutils.getConnection();
            //2.定义sql
            String sql = "INSERT INTO user VALUES(null,?,?)";
            //3.获取执行对象 PreparedStatement
            pstmt = conn.prepareStatement(sql);
            //4.？赋值
            pstmt.setString(1,"kk");
            pstmt.setString(2,"123");
            //5.执行
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCutils.close(conn,pstmt,null);
        }


    }
}
