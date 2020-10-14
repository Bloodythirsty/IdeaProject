package cn.kk;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;

@SpringBootTest(classes = CallApplication.class)
public class Test {

    // @Autowired
    // private RibbonLoadBalancerClient client;

    @org.junit.Test
    public void test() {
        RibbonLoadBalancerClient cclient = new RibbonLoadBalancerClient(new SpringClientFactory());
        for (int i = 0; i < 10; i++) {
            ServiceInstance choose = cclient.choose("user-service");
            System.out.println(choose.getHost()+":"+choose.getPort());
        }
    }
}
