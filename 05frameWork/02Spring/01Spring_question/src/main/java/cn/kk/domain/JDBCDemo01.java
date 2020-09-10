package cn.kk.domain;

import java.sql.*;

public class JDBCDemo01 {

    public static void main(String[] args) {
        try {
            //1. 注册驱动
            // DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());    5.几版本采用
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2. 获取链接
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db4_spring01 ?useSSL=false&serverTimezone=GMT",
                    "root", "root");
            //3. 获取与处理对象ps
            PreparedStatement preparedStatement = connection.prepareStatement("select * from account");
            //4. 操作
            ResultSet resultSet = preparedStatement.executeQuery();
            //5. 遍历（封装）
            while (resultSet.next()){
                System.out.println(resultSet.getInt("id")+"+"+resultSet.getString("name")+"+"+resultSet.getDouble("money"));
            }
            //6. 释放资源
            resultSet.close();
            connection.close();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
