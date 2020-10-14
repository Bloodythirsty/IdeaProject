package cn.kk.model_3_fanout;

import cn.utils.RabbitMQUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

public class Provider_3 {
    public static void main(String[] args) throws IOException {

        //获取连接对象
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();

        //将通道声明指定交换机
        /*
                参数一：交换机名称
                参数二：交换机类型
         */
        channel.exchangeDeclare("logs", "fanout");


        for (int i = 1; i <= 5; i++) {
            //发送消息
            channel.basicPublish("logs", "", null, (i + "fanout type message").getBytes());
        }

        RabbitMQUtils.closeConnAndChannel(connection, channel);
    }
}
