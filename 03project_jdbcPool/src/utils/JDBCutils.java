package utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author zkk;
 * @create 2019-12-07;
 */
public class JDBCutils {
    //1.定义成员变量
    private static DataSource ds;

    static{
        try {
            //2.配置文件
            Properties ps = new Properties();
            ps.load(JDBCutils.class.getClassLoader().getResourceAsStream("druid.properties"));
            //3.获取链接池对象
            ds = DruidDataSourceFactory.createDataSource(ps);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //获取连接池
    public static DataSource getDataSource(){
        return ds;
    }

    //获取链接
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    //释放资源，重载两个方法
    public static void close(Connection coon, Statement stmt){
//        if (coon != null) {
//            try {
//                coon.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//
//        if (stmt != null) {
//            try {
//                stmt.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
        close(coon,stmt,null);
    }

    public static void close(Connection coon, Statement stmt, ResultSet rs){
        if (coon != null) {
            try {
                coon.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (stmt != null) {
            try {
                stmt.close();
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
