package c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author zkk;
 * @create 2019-12-07;
 */

/*
连接池参数的设置
 */
public class Demo02_c3p0 {

    public static void main(String[] args) {

        //导入驱动：mysql-connector-java-8.0.18.jar
        //导入jar包： c3p0-0.9.5.2.jar   mchange-commons-java-0.2.12.jar
        //配置文件： c3p0-config.xml

        //1.创建连接池对象，无参数，使用默认设置的连接池，传相应参数，使用相应设置的连接池
        //DataSource ds = new ComboPooledDataSource();
        DataSource ds = new ComboPooledDataSource("otherc3p0");
        try {
            //2.获取链接对象
            for (int i = 0; i < 9; i++ ) {
                Connection coon = ds.getConnection();
                System.out.println(i+" , coon = " + coon);

                if (i == 5){
                    coon.close();   //归还，可以获取十一个
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
