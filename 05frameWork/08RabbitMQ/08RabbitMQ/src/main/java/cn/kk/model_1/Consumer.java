package cn.kk.model_1;

import cn.utils.RabbitMQUtils;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer {
    public static void testConsumer() throws IOException, TimeoutException {

        // //创建连接工厂
        // ConnectionFactory connectionFactory = new ConnectionFactory();
        // connectionFactory.setHost("47.94.209.35");
        // connectionFactory.setPort(5672);
        // connectionFactory.setVirtualHost("/demo01");
        // connectionFactory.setUsername("demo01");
        // connectionFactory.setPassword("demo01");
        //
        // //创建连接对象
        // Connection connection = connectionFactory.newConnection();
        Connection connection = RabbitMQUtils.getConnection();
        //创建通道
        Channel channel =  connection.createChannel();
        //绑定通道
        channel.queueDeclare("hello",true,false,false,null);

        //消费消息
        // 参数一：消费消息的队列名
        // 参数二：开始消息的自动确认机制
        // 参数三：消费时的回调接口
        channel.basicConsume("hello",true,new DefaultConsumer(channel){
            //第四个参数：去出的消息
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("new String(body) = " + new String(body));
                System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
            }

        });

        //关闭后消息取不出
        //channel.close();
        //connection.close();
    }

    public static void main(String[] args) throws IOException, TimeoutException {

        testConsumer();
        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());

    }
}
