package pack.listen;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @Author: heisenzhang@tencent.com
 * @DateTime: 2022-04-24 3:18 PM
 */
@Component
public class IndustryInfoListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("ContextRefreshedEvent 触发");
    }


    public void init(){
        System.out.println("ContextRefreshedEvent 触发");
    }
}
