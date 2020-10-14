package cn.kk.model_4_routing_1_direct;

import cn.utils.RabbitMQUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

public class Consumer41_2_warning {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare("routing_direct", "direct");
        String queueWarning = channel.queueDeclare().getQueue();
        channel.queueBind(queueWarning,"routing_direct","warning");

        channel.basicConsume(queueWarning,true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("1_waring = " + new String(body));
            }
        });

    }
}
