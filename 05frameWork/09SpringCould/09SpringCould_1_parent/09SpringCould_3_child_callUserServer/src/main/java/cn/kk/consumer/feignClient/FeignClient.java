package cn.kk.consumer.feignClient;

import cn.kk.consumer.log.FeignLog;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.cloud.openfeign.FeignClient(name = "user-service",
        fallback = FeignClientFallback.class,
        configuration = FeignLog.class
)
public interface FeignClient {
    // 以前是 "http://user-service/user/findById/"+id;
    //编写@RequestMapping，写被调服务的url
    @RequestMapping("/user/findById/{id}")
    String queryById(@PathVariable(name = "id")int id);
}
