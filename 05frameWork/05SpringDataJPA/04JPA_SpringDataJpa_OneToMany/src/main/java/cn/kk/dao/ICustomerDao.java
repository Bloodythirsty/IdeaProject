package cn.kk.dao;

import cn.kk.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cst_customer")
public interface ICustomerDao extends JpaRepository<Customer,Integer> , JpaSpecificationExecutor<Customer> {


}
