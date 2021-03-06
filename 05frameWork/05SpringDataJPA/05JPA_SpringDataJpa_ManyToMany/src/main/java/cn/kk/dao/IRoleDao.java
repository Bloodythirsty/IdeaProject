package cn.kk.dao;

import cn.kk.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IRoleDao extends JpaRepository<Role,Long>, JpaSpecificationExecutor<Role> {

}
