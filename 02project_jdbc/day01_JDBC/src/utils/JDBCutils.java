package utils;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/**
 * @author zkk;
 * @create 2019-11-29;
 */
public class JDBCutils {
    //定义静态变量，用于在静态代码块中读取配置文件。（静态代码块只能用静态变量）
    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    /*
    对于配置文件的读取：只需要读取一次即可。使用静态代码块
     */
    static{

        try {
            //1.创建Properties集合
            Properties pros = new Properties();

            //2.加载文件
                // pros.load(new FileReader("src/jdbc.properties")); 错误
            //2.1使用绝对路径
           // pros.load(new FileReader("D:\\All_Study\\java_program\\IdeaProjects\\project02\\day01_JDBC\\src\\jdbc.properties"));
            //2.1 获取src路径下文件的方式：Classloader 类加载器
            ClassLoader classloader = JDBCutils.class.getClassLoader();
            URL res = classloader.getResource("jdbc.properties");
            String path = res.getPath();    //绝对路径
            System.out.println(path);
            pros.load(new FileReader(path));


            //3.获取属性
            url = pros.getProperty("url");
            user = pros.getProperty("user");
            password = pros.getProperty("password");
            driver = pros.getProperty("driver");
            //4.注册驱动
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    //获取链接对象
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }

    //释放资源
    /*
    两种：实现重载
        1.实现增删改语句时候，释放Connection与Statement
        2.实现查询时,释放Connection与Statement与ResultSet
     */
    public static void close(Connection coon, Statement stmt){
        if (coon != null) {
            try {
                coon.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void close(Connection conn,Statement stmt,ResultSet rs){
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
