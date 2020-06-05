package lesson01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @author zkk;
 * @create 2019-11-27;
 */
public class Demo01 {
    public static void main(String[] args) throws Exception {
        //1.导入jar包
        //2.注册驱动
//        Class.forName("com.mysql.cj.jdbc.Driver");  //加载一个类，执行静态代码块里面的registerDriver
        //3. 获取数据库链接对象 Connection
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1 ?useSSL=false&serverTimezone=GMT", "root", "123456");
        //4.定义sql（更新kk为zkk）
        //String sql = "UPDATE stu2 SET name = 'aacckk' WHERE id = 2";
        String sql = "UPDATE stu2 SET name = 'aacckk' ";
        //6.执行
        Statement stmt = conn.createStatement();
        int count = stmt.executeUpdate(sql);
        //7.处理结果
        System.out.println("count = " + count);
        //8.释放资源
        stmt.close();
        conn.close();
    }
}