package cn.kk.domain;

import javax.persistence.*;

@Entity
@Table(name = "linkman_04")
public class Linkman {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lkm_id")
    private Integer id;

    @Column(name = "lkm_name")
    private String name;

    @Column(name = "lkm_gender")
    private String gender;

    @Column(name = "lkm_phone")
    private String phone;

    @Column(name = "lkm_mobile")
    private String mobile;

    @Column(name = "lkm_email")
    private String email;

    @Column(name = "lkm_position")
    private String position;

    @Column(name = "lkm_memo")
    private String memo;


    @ManyToOne(targetEntity = Customer.class,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "lkm_cust_id",referencedColumnName = "cust_id")
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    // @Column(name = "lkm_cust_id")
    // private Integer lkm_cust_id;


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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Override
    public String toString() {
        return "Linkman{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", position='" + position + '\'' +
                ", memo='" + memo + '\'' +
                '}';
    }
}
