package cn.kk.consumer.consumer;

import cn.kk.consumer.feignClient.FeignClient;
import cn.kk.consumer.pojo.User;
import com.netflix.discovery.converters.Auto;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/*
    DefaultProperties :设置通用熔断降级方法
 */
@DefaultProperties(defaultFallback = "defaultFallback")
@RestController
@RequestMapping("/consumer")
public class ConsumerController {
    @Autowired
    private RestTemplate template;

    //帮助获取服务，实例
    // @Autowired
    // private DiscoveryClient discoveryClient;
    // private RibbonLoadBalancerClient client;

    // @HystrixCommand(fallbackMethod = "findByIdFallback")
    // @RequestMapping("/call/{id}")
    // public User callUserService(@PathVariable(name = "id")int id){
    //     /*
    //             没用ribbon
    //      */
    //     // //拉取实例列表（因为一个服务可以部署到多地方，所以一个服务可有多个实例）
    //     // List<ServiceInstance> instances = discoveryClient.getInstances("USER-SERVICE");
    //     // //因为目前只有一个，就取0
    //     // ServiceInstance instance = instances.get(0);
    //
    //
    //     /*
    //             ribbon写法1，得到的就一个
    //      */
    //     // ServiceInstance instance = client.choose("user-service");
    //
    //     //获取ip，port
    //     // String hostAndPort = instance.getHost() + ":" + instance.getPort();
    //     // String callUrl = "http://localhost:8080/user/findById/"+id;
    //     // String callUrl = "http://"+hostAndPort+"/user/findById/"+id;
    //
    //
    //     /*
    //             ribbon写法二
    //      */
    //     String callUrl  = "http://user-service/user/findById/"+id;
    //     User user = template.getForObject(callUrl, User.class);
    //     return user;
    // }


    /*
            熔断降级:
            1. 为了友好，返回String类型
            2. fallbackMethod 和 本来的方法必须返回值一致，参数一致

            @HystrixCommand(fallbackMethod = "findByIdFallback")
            写在方法上

            类上有了 @DefaultProperties(defaultFallback = "findByIdFallback")
            方法上只需提供：@HystrixCommand
     */
    //@HystrixCommand(fallbackMethod = "findByIdFallback")
    // @HystrixCommand(commandProperties = {
    //         @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2500")
    // })
    // @HystrixCommand(commandProperties = {
    //         //休眠时间窗10s
    //         @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
    //         //10次阈值，即5次失败就触发熔断
    //         @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10")
    // })
    // @RequestMapping("/call/{id}")
    // public String callUserService(@PathVariable(name = "id")int id){
    //     if (id%2 == 0){ //手动模拟访问失败,因为超时和断开服务都不好控制
    //         throw new RuntimeException("id%2 == 0");
    //     }
    //     String callUrl  = "http://user-service/user/findById/"+id;
    //     String user = template.getForObject(callUrl, String.class);
    //     return user;
    // }



    /*
            下面是feign功能
     */
    @Autowired
    private FeignClient client;

    @HystrixCommand(commandProperties = {
            //休眠时间窗10s
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
            //10次阈值，即5次失败就触发熔断
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10")
    })
    @RequestMapping("/call/{id}")
    public String callUserService(@PathVariable(name = "id")int id){
        return client.queryById(id);
    }

    public String findByIdFallback(int id){
        return "服务器忙！稍后访问";
    }

    public String defaultFallback(){
        return "服务器忙！稍后访问 defaultFallback";
    }
}
