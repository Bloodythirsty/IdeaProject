package cn.kk.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Data
@Table(name = "user")
public class User {
    // 主键
    @Id
    @KeySql(useGeneratedKeys = true)                 //回显（import tk.mybatis.mapper.annotation.KeySql）
    private Long id;
    // 用户名
    private String username;
    // 密码
    private String password;
    // 姓名
    private String name;

    @Transient          //临时数据，不需要插入数据库
    private String aaaa;
}