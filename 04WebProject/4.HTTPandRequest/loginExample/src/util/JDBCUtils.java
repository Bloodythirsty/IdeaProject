package util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author zkk;
 * @create 2020-03-25;
 * JDBC工具类，使用durid连接池
 */
public class JDBCUtils {
    /*
     1. 获取连接池对象
     2. 获取连接Connection对象
     */

    private static DataSource ds;

    //静态代码块
    static{

        try {
            Properties ppts = new Properties();
            /*
            properties中的load方法可以传reader或者inputStream
             */
//            String path = JDBCUtils.class.getClassLoader().getResource("druid.properties").getPath(); //获取路径
//            ppts.load(new FileReader(path));
            ppts.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(ppts);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //获取连接池对象
    public static DataSource getDataSource(){
        return ds;
    }

    //获取connection对象
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
