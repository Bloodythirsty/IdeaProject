package cn.kk.pojo;


import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Province {
    private Integer id;
    private String name;
    private String tags;
    private Integer placecounts;
}
