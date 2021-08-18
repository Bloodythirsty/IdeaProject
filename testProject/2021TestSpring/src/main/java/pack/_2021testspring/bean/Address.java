package pack._2021testspring.bean;

import com.google.common.collect.Maps;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * @author zhangkangkang created on 2021/2/5 5:45 下午
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Service
public class Address {

    private String province;
    private String city;
    private String country;

    Map<String ,String> map = Maps.newHashMap();


    @PostConstruct
    private void init(){
        map.put("1","first");
        map.put("2","second");
        map.put("3","third");
        map.put("4","four");
    }

    public void testInit(){
        String s = map.get("1");
        System.out.println("s = " + s);
    }

}
