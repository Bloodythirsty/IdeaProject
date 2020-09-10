package cn.kk.service.impl;

import cn.kk.dao.ISysLogDao;
import cn.kk.domain.SysLog;
import cn.kk.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysLogServiceImpl implements ISysLogService {

    @Autowired
    private ISysLogDao sysLogDao;

    @Override
    public void saveLog(SysLog sysLog) throws Exception {
        sysLogDao.saveLog(sysLog);
    }

    @Override
    public List<SysLog> findAll() throws Exception {
        return sysLogDao.findAll();
    }
}
