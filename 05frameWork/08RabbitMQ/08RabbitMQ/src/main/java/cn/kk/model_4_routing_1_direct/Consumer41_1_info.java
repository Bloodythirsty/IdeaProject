package cn.kk.model_4_routing_1_direct;

import cn.utils.RabbitMQUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

public class Consumer41_1_info {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();
        //绑定交换机
        channel.exchangeDeclare("routing_direct","direct");
        //建立临时队列
        String infoQueue = channel.queueDeclare().getQueue();
        //绑定
        channel.queueBind(infoQueue,"routing_direct","info");
        channel.queueBind(infoQueue,"routing_direct","warning");

        //消费
        channel.basicConsume(infoQueue,true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("1_info = " + new String(body));
            }
        });
    }
}
