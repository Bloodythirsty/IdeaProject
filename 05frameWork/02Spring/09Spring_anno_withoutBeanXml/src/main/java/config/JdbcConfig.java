package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

// @Configuration
public class JdbcConfig {

    @Value("${driver}")
    private String driver;

    @Value("${url}")
    private String url;

    @Value("${root}")
    private String root;

    @Value("${password}")
    private String password;



    /*
            创建一个QueryRun
     */
    @Bean(name = "runner")
    @Scope("prototype")     //多例
    public QueryRunner createQueryRunner(@Qualifier("dataSource2") DataSource dataSource){
        return new QueryRunner(dataSource);
    }

    /*
            创建数据源
     */
    @Bean(name = "dataSource")
    public DataSource createDataSource(){
        try{

            ComboPooledDataSource ds = new ComboPooledDataSource();
            // ds.setDriverClass(properties.getProperty("driver"));     //使用注解写
            // ds.setJdbcUrl(properties.getProperty("url"));
            // ds.setUser(properties.getProperty("root"));
            // ds.setPassword(properties.getProperty("password"));
            ds.setDriverClass(driver);
            ds.setJdbcUrl(url);
            ds.setUser(root);
            ds.setPassword(password);
            return ds;
        }catch (Exception e){
            // e.printStackTrace();
            // return null;             当写e.printStackTrace();还必须要返回
            throw new RuntimeException(e);
        }
    }

    @Bean(name = "dataSource2")
    public DataSource createDataSource2(){
        try{
            ComboPooledDataSource ds = new ComboPooledDataSource();
            ds.setDriverClass(driver);
            ds.setJdbcUrl(url);
            ds.setUser(root);
            ds.setPassword(password);
            return ds;
        }catch (Exception e){
            // e.printStackTrace();
            // return null;             当写e.printStackTrace();还必须要返回
            throw new RuntimeException(e);
        }
    }
}
