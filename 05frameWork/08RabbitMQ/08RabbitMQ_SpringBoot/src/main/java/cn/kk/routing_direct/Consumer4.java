package cn.kk.routing_direct;

import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
public class Consumer4 {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue,
            exchange = @Exchange(name = "routing_direct"),
            key = "info"
    ))
    @RabbitHandler
    public void Consumer4_1(String message){
        System.out.println("Consumer4_1_info = " + message);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue,
            exchange = @Exchange(name = "routing_direct"),
            key = "warning"
    ))
    @RabbitHandler
    public void Consumer4_2(String message){
        System.out.println("Consumer4_2_warning = " + message);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue,
            exchange = @Exchange(name = "routing_direct"),
            key = "error"
    ))
    @RabbitHandler
    public void Consumer4_3(String message){
        System.out.println("Consumer4_3_error = " + message);
    }

}
