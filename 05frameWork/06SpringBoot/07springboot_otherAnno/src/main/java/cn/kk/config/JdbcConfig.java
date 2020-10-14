package cn.kk.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
// @PropertySource("classpath:application.properties")  获取properties,用于@Value获取
// @EnableConfigurationProperties(JdbcProperties.class)    //使用里面的属性
public class JdbcConfig {

    // @Value("${driver}")
    // String driver;
    // String url;
    // String username;
    // String password;

    // @Bean
    // public DataSource dataSource(JdbcProperties properties){
    //     DruidDataSource druidDataSource = new DruidDataSource();
        // druidDataSource.setDriverClassName(properties.getDriver());
    //     druidDataSource.setUrl(properties.getUrl());
    //     druidDataSource.setUsername(properties.getUsername());
    //     druidDataSource.setPassword(properties.getPassword());
    //
    //     return druidDataSource;
    // }

    @Bean
    @ConfigurationProperties(prefix = "jdbc")
    public DataSource dataSource(){
        return new DruidDataSource();
    }
}
