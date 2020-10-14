package cn.kk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

// @EnableCircuitBreaker
// @EnableDiscoveryClient
// @SpringBootApplication

@EnableFeignClients
@SpringCloudApplication
public class CallApplication {
    public static void main(String[] args) {
        SpringApplication.run(CallApplication.class,args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    // @Bean
    // public RibbonLoadBalancerClient client(){
    //     return new RibbonLoadBalancerClient(new SpringClientFactory());
    // }
}
