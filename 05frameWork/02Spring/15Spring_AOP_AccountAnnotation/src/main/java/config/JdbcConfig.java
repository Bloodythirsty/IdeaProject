package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;


@Configuration
public class JdbcConfig {

    @Bean("queryRunner")
    @Scope("prototype")
    public QueryRunner createQueryRunner(){
        return new QueryRunner();
    }


    @Bean("dataSource")
    public DataSource createDataSource(){
        try{
            ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();

            comboPooledDataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
            comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/db4_spring01 ?useSSL=false&serverTimezone=GMT");
            comboPooledDataSource.setUser("root");
            comboPooledDataSource.setPassword("root");
            return comboPooledDataSource;
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
