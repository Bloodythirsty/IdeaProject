package cn.kk.model_3_fanout;

import cn.utils.RabbitMQUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

public class Consumer3_1 {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();

        //声明交换机
        channel.exchangeDeclare("logs","fanout");

        //临时队列
        String queue = channel.queueDeclare().getQueue();

        //绑定交换机和队列
        channel.queueBind(queue, "logs", "");

        //消费消息
        channel.basicConsume(queue,true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("consumer3_1 = " + new String(body));
            }
        });
    }
}
