package cn.utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeoutException;

public class RabbitMQUtils {

    private static ConnectionFactory connectionFactory = new ConnectionFactory();

    //类加载执行一次就行
    static {
        Properties props = new Properties();
        InputStream is = RabbitMQUtils.class.getClassLoader().getResourceAsStream("rabbitMQ.properties");
        try {
            props.load(is);
            connectionFactory.setHost(props.getProperty("host"));
            connectionFactory.setPort(Integer.parseInt(props.getProperty("post")));
            connectionFactory.setVirtualHost(props.getProperty("virtualHost"));
            connectionFactory.setUsername(props.getProperty("user"));
            connectionFactory.setPassword(props.getProperty("password"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        try {
             return connectionFactory.newConnection();
        } catch (Exception e) {
            throw new RuntimeException("connection is null!");
        }
    }

    public static void closeConnAndChannel(Connection conn, Channel channel){
        try {
            if (channel != null) channel.close();
            if (conn != null) conn.close();
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
    }
}
