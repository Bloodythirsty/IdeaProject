package cn.kk.dao;

import cn.kk.domain.Linkman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ILinkManDao extends JpaRepository<Linkman,Integer>, JpaSpecificationExecutor<Linkman> {

}
