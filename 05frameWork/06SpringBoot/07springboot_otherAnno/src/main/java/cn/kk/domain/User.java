package cn.kk.domain;

import lombok.Data;

import java.util.List;

@Data
public class User {
    // 主键
    private Long id;
    // 用户名
    private String username;
    // 密码
    private String password;
    // 姓名
    private String name;

    private List<Integer> list;

}
