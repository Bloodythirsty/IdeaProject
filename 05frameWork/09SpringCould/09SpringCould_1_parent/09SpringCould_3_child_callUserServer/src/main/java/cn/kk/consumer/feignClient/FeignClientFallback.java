package cn.kk.consumer.feignClient;

import org.springframework.stereotype.Component;

@Component
public class FeignClientFallback implements FeignClient {
    @Override
    public String queryById(int id) {
        return "feign fall back~";
    }
}
