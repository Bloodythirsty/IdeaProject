package cn.kk.model_1;

import cn.utils.RabbitMQUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.concurrent.TimeoutException;


public class Provider {

    public static void testSendMessage () throws IOException, TimeoutException {
        // //创建连接工程
        // ConnectionFactory connectionFactory = new ConnectionFactory();
        // // 设置连接主机
        // connectionFactory.setHost("47.94.209.35");
        // //设置端口
        // connectionFactory.setPort(5672);
        // //设置虚拟主机
        // connectionFactory.setVirtualHost("/demo01");
        // //设置用户名密码
        // connectionFactory.setUsername("demo01");
        // connectionFactory.setPassword("demo01");
        //
        // //获取连接对象
        // Connection connection = connectionFactory.newConnection();

        Connection connection = RabbitMQUtils.getConnection();
        //获取连接通道
        Channel channel = connection.createChannel();
        //通道绑定消息队列
        // 参数1：队列名称（不存在自动创建）
        // 参数二：durable，是否持久化队列（即关闭MQ是否存到磁盘）
        // 参数三：exclusive，是否独占队列（能否被其他队列享用）
        // 参数四：autoDelete，是否在消费完成后，自动删除队列（false不删除）
        // 参数五：额外参宿，Map
        /*
                此处是显示声明了队列，所以会产生队列
                而springBoot中生产者没有声明队列，只是指定了routingKey和Object，因此没有队列
         */
        channel.queueDeclare("hello",true,false,false,null);

        //发布消息
        // 参数1：交换机名称
        // 参数二：队列名
        // 参数三：传递消息的额外设置(是否持久化等)
        // 参数四：消息内容
        //channel.basicPublish("","hello",null,"hello rabbitMq".getBytes());
        /*
                 MessageProperties.PERSISTENT_TEXT_PLAIN 消息持久化
         */
        channel.basicPublish("","hello", MessageProperties.PERSISTENT_TEXT_PLAIN,"hello rabbitMq".getBytes());

        RabbitMQUtils.closeConnAndChannel(connection,channel);
    }

    public static void main(String[] args) throws IOException, TimeoutException {
        testSendMessage();
    }
}
