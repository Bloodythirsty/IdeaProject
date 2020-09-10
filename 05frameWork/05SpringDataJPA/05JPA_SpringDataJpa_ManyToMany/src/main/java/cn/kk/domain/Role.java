package cn.kk.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "05_role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "r_id")
    private Long roleId;

    @Column(name = "r_name")
    private String roleName;

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

    // @ManyToMany(targetEntity = User.class)
    // @JoinTable(name = "05_user_role",
    //         joinColumns ={@JoinColumn(name = "f_role_id",referencedColumnName = "r_id")},
    //         inverseJoinColumns = {@JoinColumn(name = "f_user_id",referencedColumnName = "u_id")}
    // )
    @ManyToMany(mappedBy = "roleSet")
    private Set<User> userSet = new HashSet<User>();

    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
