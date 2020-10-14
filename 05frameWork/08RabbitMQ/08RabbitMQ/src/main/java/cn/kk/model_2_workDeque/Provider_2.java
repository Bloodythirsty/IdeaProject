package cn.kk.model_2_workDeque;

import cn.utils.RabbitMQUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

public class Provider_2 {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare("work",false,false,false,null);
        for (int i = 1; i <= 20 ; i++) {
            channel.basicPublish("","work",null,(i+" hello RabbitMQ").getBytes());
        }
        RabbitMQUtils.closeConnAndChannel(connection,channel);
    }
}
