package mybatis.utils;

import mybatis.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *      用于创建数据源的工具类
 */
public class DateSourceUtil {

    public static Connection getConnection(Configuration cfg)  {
        try {
            Class.forName(cfg.getDriver());
            return DriverManager.getConnection(cfg.getUrl(), cfg.getPassword(), cfg.getPassword());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // try {
        //     Class.forName(cfg.getDriver());
        //     return DriverManager.getConnection(cfg.getUrl(), cfg.getPassword(), cfg.getPassword());
        // } catch (Exception e){
        //     e.printStackTrace();
        // }
    }
}
