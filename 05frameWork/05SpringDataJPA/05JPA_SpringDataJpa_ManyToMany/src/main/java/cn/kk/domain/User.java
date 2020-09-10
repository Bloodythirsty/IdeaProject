package cn.kk.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "05_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "u_id")
    private Long userId;

    @Column(name = "u_name")
    private String userName;

    @Column(name = "u_age")
    private Integer userAge;


    /*
            配置多对多的关系

        1. 声明表关系：
			1. `@ManyToMany(targetEntity = 对方实体类.class)`
		2. 配置中间表（包含两个外键）
			1. `@JoinTable`
			2. 属性：
				1. `name`：中间表名称
				2. `joinColumns`是@JoinColumn数组：当前对象在中间表的名称
				3. `inverseJoinColumns`是@JoinColumn数组：对方对象在中间表的名称
     */
    @ManyToMany(targetEntity = Role.class, cascade = CascadeType.ALL)
    @JoinTable(name = "05_user_role",
            joinColumns = {@JoinColumn(name = "f_user_id",referencedColumnName = "u_id")},
            inverseJoinColumns = {@JoinColumn(name = "f_role_id",referencedColumnName = "r_id")})
    private Set<Role> roleSet = new HashSet<Role>();

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userAge=" + userAge +
                '}';
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public Set<Role> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }
}
