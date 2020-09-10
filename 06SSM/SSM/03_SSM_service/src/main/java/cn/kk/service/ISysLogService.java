package cn.kk.service;

import cn.kk.domain.SysLog;

import java.util.List;

public interface ISysLogService {
    public void saveLog(SysLog sysLog) throws Exception;
    public List<SysLog> findAll() throws Exception;
}
