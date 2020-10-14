package cn.kk.demo02_work;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer2 {
    /*
            每个方法定义一个Consumer

            此时默认是平均分配的
     */
    @RabbitListener(queuesToDeclare = @Queue(name = "work"))
    @RabbitHandler
    public void Consumer2_1(String message){
        System.out.println("Consumer2_1 = " + message);
    }

    @RabbitListener(queuesToDeclare = @Queue(name = "work"))
    @RabbitHandler
    public void Consumer2_2(String message){
        System.out.println("Consumer2_2 = " + message);
    }
}
