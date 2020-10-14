package cn.kk.model_3_fanout;

import cn.utils.RabbitMQUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

public class Consumer3_2 {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();
        //声明交换机
        channel.exchangeDeclare("logs","fanout");
        //绑定队列和交换机
        String queue = channel.queueDeclare().getQueue();
        channel.queueBind(queue,"logs","");

        //从队列中消费消息
        channel.basicConsume(queue,true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Consumer3_2 = " + new String(body));
            }
        });
    }
}
