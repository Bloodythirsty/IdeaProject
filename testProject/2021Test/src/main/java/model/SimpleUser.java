package model;

import lombok.Builder;
import lombok.Data;

/**
 * @author zhangkangkang created on 2021/3/8 5:57 下午
 */
@Data
@Builder
public class SimpleUser {
    private int name;
    private int age;
}
