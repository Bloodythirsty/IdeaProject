package c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author zkk;
 * @create 2019-12-07;
 */
public class Demo01_c3p0 {
    public static void main(String[] args) {
        //导入驱动：mysql-connector-java-8.0.18.jar
        //导入jar包： c3p0-0.9.5.2.jar   mchange-commons-java-0.2.12.jar
        //配置文件： c3p0-config.xml
        //1.创建连接池对象
        DataSource ds = new ComboPooledDataSource();
        try {
            //2.获取连接池对象
            Connection conn = ds.getConnection();
            System.out.println("conn = " + conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
