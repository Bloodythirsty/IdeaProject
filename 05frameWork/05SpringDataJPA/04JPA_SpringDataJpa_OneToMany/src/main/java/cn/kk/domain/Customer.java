package cn.kk.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customer_04")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id")
    private Integer id;

    @Column(name = "cust_name")
    private String name;

    @Column(name = "cust_source")
    private String source;

    @Column(name = "cust_industry")
    private String industry;

    @Column(name = "cust_level")
    private String level;

    @Column(name = "cust_address")
    private String address;

    @Column(name = "cust_phone")
    private String phone;

    // 配置客户跟联系人之间的关系（一对多）
    // @OneToMany(targetEntity = Linkman.class)
    // @JoinColumn(name = "lkm_cust_id",referencedColumnName = "cust_id")
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)   //外键的描述，参照LinkMan里面的customer属性
    private Set<Linkman> linkMans = new HashSet<Linkman>();

    public Set<Linkman> getLinkMans() {
        return linkMans;
    }

    public void setLinkMans(Set<Linkman> linkMans) {
        this.linkMans = linkMans;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", source='" + source + '\'' +
                ", industry='" + industry + '\'' +
                ", level='" + level + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
