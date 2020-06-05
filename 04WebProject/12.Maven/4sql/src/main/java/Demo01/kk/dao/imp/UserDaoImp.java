package Demo01.kk.dao.imp;

import Demo01.kk.dao.UserDao;
import Demo01.kk.domain.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImp implements UserDao {

    public List<User> findAll() throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<User> list = null;

        try {
            // 5.几版本
//            //加载驱动类
//            Class.forName("com.mysql.jdbc.Driver");
//            //1. 获取连接对象
//            connection = DriverManager.getConnection("jdbc:mysql:///db1","root","root");

            // 8以上版本
            //加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            //1. 获取连接对象
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1  ?useSSL=false&serverTimezone=GMT","root","root");

            //2. 操作数据库对象
            preparedStatement = connection.prepareStatement("select * from user");
            ResultSet resultSet = preparedStatement.executeQuery();
            //3. 转成list集合
            list = new ArrayList<User>();
            while(resultSet.next()){                    //查看以前jdbc笔记
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setGender(resultSet.getString("gender"));
                list.add(user);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }finally {
            if (connection != null){
                connection.close();
            }
            if (preparedStatement != null){
                preparedStatement.close();
            }
        }


        return list;
    }
}
