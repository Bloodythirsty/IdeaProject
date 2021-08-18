package pack._2021testspring.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author zhangkangkang created on 2021/2/5 5:45 下午
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String name;
    private int age;
    @JsonProperty("address_ad")
    private Address address;
    private Date bir;
}
