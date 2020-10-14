package cn.kk;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = RabbitmqApplication.class)
@RunWith(SpringRunner.class)
public class TestRabbitMq {
    //注入rabbitTemplate
    @Autowired
    private RabbitTemplate rabbitTemplate;

    /*
            helloword
     */

    @Test
    public void testModel1_helloWord() {
        rabbitTemplate.convertAndSend("hello","hello word");
    }

    /*
            work
     */
    @Test
    public void testModel2_work() {
        for (int i = 1; i <=10 ; i++) {
            rabbitTemplate.convertAndSend("work",i+"_workModel_work");
        }
    }
    /*
            fanout
     */

    @Test
    public void testFanout() {
        for (int i = 1; i <=10 ; i++) {
            rabbitTemplate.convertAndSend("logs","",i+"_workModel_fanout");
        }
    }

    /*
            routing
     */

    @Test
    public void testRouting() {
        for (int i = 1; i <= 10 ; i++) {
            int random = (int) Math.ceil(Math.random() * 100);
            switch (random%3){
                case 0:
                    rabbitTemplate.convertAndSend("routing_direct","info",(i + "_info"));
                    break;
                case 1:
                    rabbitTemplate.convertAndSend("routing_direct","warning",(i + "_warning"));
                    break;
                case 2:
                    rabbitTemplate.convertAndSend("routing_direct","error",(i + "_error"));
                    break;
            }
        }
    }


    @Test
    public void testTopic() {
        for (int i = 1; i <= 10 ; i++) {
            int random = (int) Math.ceil(Math.random() * 100);
            switch (random%3){
                case 0:
                    rabbitTemplate.convertAndSend("topic_logs","info.rabbit.quick",(i + "_info.rabbit.quick"));
                    break;
                case 1:
                    rabbitTemplate.convertAndSend("topic_logs","info.rabbit.lazy",(i + "_info.rabbit.lazy"));
                    break;
                case 2:
                    rabbitTemplate.convertAndSend("topic_logs","info.fox.lazy",(i + "_info.fox.lazy"));
                    break;
            }
        }
    }
}
