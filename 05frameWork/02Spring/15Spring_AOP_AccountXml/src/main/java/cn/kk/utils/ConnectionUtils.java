package cn.kk.utils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/*
        链接工具类：用于从数据源中获取一个链接，并且实现和线程的绑定
 */
public class ConnectionUtils {
    private ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /*
                获取当前线程上的链接
         */
    public Connection getThreadConnection(){
        //1. 先从ThreadLocal上获取
        Connection conn = tl.get();
        //2. 判断当前线程是否有链接
        if( conn == null ){
            try {
                //3. 从数据原上获取一个链接，并存入ThreadLocal中
                conn = dataSource.getConnection();
                tl.set(conn);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        //4. 返回当前线程的链接
        return conn;
    }

    /*
            解绑：
                因为线程上已经绑定了一个Connection
                用完后线程归还到线程池中并且绑定的Connection已经关闭，
                再次获取此线程上的Connection时，connection已经关闭，无法使用
     */
    public void removeConnection(){
        tl.remove();
    }
}
