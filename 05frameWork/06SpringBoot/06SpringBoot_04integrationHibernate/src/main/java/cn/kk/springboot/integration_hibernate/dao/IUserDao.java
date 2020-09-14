package cn.kk.springboot.integration_hibernate.dao;

import cn.kk.springboot.integration_hibernate.domian.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface IUserDao  extends JpaRepository<User,Long>, JpaSpecificationExecutor<User> {

}
