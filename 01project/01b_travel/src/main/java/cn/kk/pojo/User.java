package cn.kk.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@AllArgsConstructor     //有参
@NoArgsConstructor      //无参
@ToString               //toString
@Accessors(chain = true)
public class User implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private String email;
}
