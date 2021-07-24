// package com.kk.config;
//
// import com.alibaba.druid.pool.DruidDataSource;
// import com.alibaba.druid.support.http.StatViewServlet;
// import com.alibaba.druid.support.http.WebStatFilter;
// import org.springframework.boot.context.properties.ConfigurationProperties;
// import org.springframework.boot.web.servlet.FilterRegistrationBean;
// import org.springframework.boot.web.servlet.ServletRegistrationBean;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
//
// import javax.servlet.Filter;
// import javax.servlet.Servlet;
// import javax.sql.DataSource;
//
// @Configuration
// public class DruidConfig {
//
//     @Bean
//     @ConfigurationProperties(prefix = "spring.datasource")
//     public DataSource druidDataSourse(){
//         return new DruidDataSource();
//     }
//
//     @Bean
//     public ServletRegistrationBean<Servlet> druidServlet(){
//         ServletRegistrationBean<Servlet> srb = new ServletRegistrationBean<>(new StatViewServlet());
//         //白名单
//         srb.addInitParameter("allow","127.0.0.1");
//         //黑名单
//         srb.addInitParameter("denny","192.168.31.253");
//         //用户名
//         srb.addInitParameter("loginUsername","root");
//         //密码
//         srb.addInitParameter("loginPassword","root");
//         //是否可重置数据源
//         srb.addInitParameter("resetEnable","false");
//         return srb;
//     }
//
//     @Bean
//     public FilterRegistrationBean<Filter> filterRegistrationBean(){
//         FilterRegistrationBean<Filter> frb = new FilterRegistrationBean<>();
//         frb.setFilter(new WebStatFilter());
//         //所有请求监控处理
//         frb.addUrlPatterns("/*");
//         //排除监控
//         frb.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.css,/druid/*");
//         return frb;
//     }
// }
