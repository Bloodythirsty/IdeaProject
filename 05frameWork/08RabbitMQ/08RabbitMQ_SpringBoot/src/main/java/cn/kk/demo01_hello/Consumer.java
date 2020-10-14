package cn.kk.demo01_hello;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
//监听队列
@RabbitListener(queuesToDeclare = @Queue(name = "hello",durable = "false",autoDelete = "false"))
public class Consumer {

    /*
        @RabbitHandler  代表回调方法
     */
    @RabbitHandler
    public void receiver(String message){
        System.out.println("message = " + message);
    }
}
