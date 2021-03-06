package cn.kk.model_2_workDeque;

import cn.utils.RabbitMQUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

public class Consumer2_1 {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();
        final Channel channel = connection.createChannel();
        //每次通道发送一个消息
        channel.basicQos(1);
        channel.queueDeclare("work",false,false,false,null);
        channel.basicConsume("work",false,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                //手动确认
                channel.basicAck(envelope.getDeliveryTag(),false);
                System.out.println("consumer2_1 = " + new String(body));
            }
        });
    }
}
