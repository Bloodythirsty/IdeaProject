package cn.kk.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


/*
        配置durid

        @Data注解：生成geter seter hash equal constructor等
 */
// @ConfigurationProperties(prefix = "jdbc")
// @ConfigurationProperties(prefix = "kk.jdbc")
@Data
public class JdbcProperties {
    private String driver;
    private String url;
    private String username;
    private String password;
}
