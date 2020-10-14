package cn.kk.demo03_fanout;

import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
public class Consumer3 {

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,  //创建临时队列
                    exchange = @Exchange(name = "logs",type = "fanout")
            )
    })
    @RabbitHandler
    public void Consumer3_1(String message){
        System.out.println("Consumer3_1 = " + message);
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,  //创建临时队列
                    exchange = @Exchange(name = "logs",type = "fanout")
            )
    })
    @RabbitHandler
    public void Consumer3_2(String message){
        System.out.println("Consumer3_2 = " + message);
    }
}
