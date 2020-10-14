package cn.kk.routing_topic;

import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
public class Consumer5 {


    @RabbitListener(bindings = @QueueBinding(
            value = @Queue,
            exchange = @Exchange(value = "topic_logs",type = "topic"),
            key = "info.#"
    ))
    @RabbitHandler
    public void consumer5_1(String message){
        System.out.println("consumer5_1_info = " + message);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue,
            exchange = @Exchange(value = "topic_logs",type = "topic"),
            key = "*.rabbit.*"
    ))
    @RabbitHandler
    public void consumer5_2(String message){
        System.out.println("consumer5_2_rabbit = " + message);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue,
            exchange = @Exchange(value = "topic_logs",type = "topic"),
            key = "#.lazy"
    ))
    @RabbitHandler
    public void consumer5_3(String message){
        System.out.println("consumer5_3_lazy = " + message);
    }

}
