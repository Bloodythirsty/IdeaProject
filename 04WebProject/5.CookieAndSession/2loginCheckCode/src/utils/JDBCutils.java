package utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author zkk;
 * @create 2020-03-31;
 */
public class JDBCutils {
    //1. 定义静态成员变量datasource
    private static DataSource ds;

    //2. 静态代码块，连接sql
    static{
        try {
            Properties properties = new Properties();
            //3. properties装进内存
            properties.load(JDBCutils.class.getClassLoader().getResourceAsStream("druid.properties"));
            //4. 直接用druid获取datasource
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //5. 静态获取dataSource
    public static DataSource getDataSource(){
        return ds;
    }

    //6. 用dataSource获取静态连接对象
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
