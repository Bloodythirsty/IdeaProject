package cn.kk.model_4_routing_1_direct;

import cn.utils.RabbitMQUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

public class Consumer41_3_error {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare("routing_direct","direct");
        String queueError = channel.queueDeclare().getQueue();
        channel.queueBind(queueError,"routing_direct","error");

        channel.basicConsume(queueError,true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("3_error = " + new String(body));
            }
        });

    }
}
