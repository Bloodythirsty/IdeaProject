package cn.kk.dao;

import cn.kk.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISysLogDao {

    @Insert("insert into sysLog(id,visitTime,username,ip,url,executionTime,method) values(#{id},#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    public void saveLog(SysLog sysLog) throws Exception;

    @Select("select * from sysLog")
    public List<SysLog> findAll() throws Exception;
}
