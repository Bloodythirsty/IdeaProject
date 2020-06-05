package jdcbUtils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.jdbc.datasource.embedded.DataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {
    private static DataSource ds;
    
    static{
        InputStream is = JdbcUtils.class.getClassLoader().getResourceAsStream("druid.properties");
        Properties properties = new Properties();
        try {
            properties.load(is);
        } catch (IOException e) {
            System.out.println("记载失败");
            e.printStackTrace();
        }

        try {
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            System.out.println("获取连接池失败");
            e.printStackTrace();
        }

    }

    public static DataSource getDataSource(){
        return ds;
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }


}
