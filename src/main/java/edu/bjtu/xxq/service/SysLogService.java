package edu.bjtu.xxq.service;

import edu.bjtu.xxq.dao.SysLogDao;
import edu.bjtu.xxq.model.SysLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysLogService {
    @Autowired
    private SysLogDao sysLogDao;
    public boolean saveLog(SysLog sysLog){
        return sysLogDao.save(sysLog);
    }
}
