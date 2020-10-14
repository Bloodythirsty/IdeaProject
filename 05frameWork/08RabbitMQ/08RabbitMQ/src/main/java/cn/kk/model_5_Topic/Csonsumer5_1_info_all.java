package cn.kk.model_5_Topic;

import cn.utils.RabbitMQUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

public class Csonsumer5_1_info_all {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare("topic_logs","topic");
        String queueInfoAll = channel.queueDeclare().getQueue();
        channel.queueBind(queueInfoAll,"topic_logs","info.#");

        channel.basicConsume(queueInfoAll,true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("info_all = " + new String(body));
            }
        });
    }
}
