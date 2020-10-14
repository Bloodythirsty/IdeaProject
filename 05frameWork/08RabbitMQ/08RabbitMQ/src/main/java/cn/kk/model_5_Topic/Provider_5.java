package cn.kk.model_5_Topic;

import cn.utils.RabbitMQUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

public class Provider_5 {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare("topic_logs","topic");

        for (int i = 1; i <= 10 ; i++) {
            int random = (int) Math.ceil(Math.random() * 100);
            switch (random%3){
                case 0:
                    channel.basicPublish("topic_logs","info.rabbit.quick",null,(i + "_info.rabbit.quick").getBytes());
                    break;
                case 1:
                    channel.basicPublish("topic_logs","info.rabbit.lazy",null,(i + "_info.rabbit.lazy").getBytes());
                    break;
                case 2:
                    channel.basicPublish("topic_logs","info.fox.lazy",null,(i + "_info.fox.lazy").getBytes());
                    break;
            }
        }
        RabbitMQUtils.closeConnAndChannel(connection,channel);
    }
}
