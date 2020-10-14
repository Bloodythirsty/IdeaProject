package cn.kk.model_4_routing_1_direct;

import cn.utils.RabbitMQUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

public class Provider_4_1 {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare("routing_direct","direct");

        for (int i = 1; i <= 10 ; i++) {
            int random = (int) Math.ceil(Math.random() * 100);
            switch (random%3){
                case 0:
                    channel.basicPublish("routing_direct","info",null,(i + "_info").getBytes());
                    break;
                case 1:
                    channel.basicPublish("routing_direct","warning",null,(i + "_warning").getBytes());
                    break;
                case 2:
                    channel.basicPublish("routing_direct","error",null,(i + "_error").getBytes());
                    break;
            }
        }

        RabbitMQUtils.closeConnAndChannel(connection,channel);
    }
}
