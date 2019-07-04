package edu.bjtu.xxq.service;

import edu.bjtu.xxq.dao.SysLogDao;
import edu.bjtu.xxq.model.SysLog;

public class SysLogService {
    private SysLogDao sysLogDao;
    public boolean saveLog(SysLog sysLog){
        return sysLogDao.save(sysLog);
    }
}
