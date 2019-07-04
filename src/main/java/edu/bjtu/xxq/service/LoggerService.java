package edu.bjtu.xxq.service;

import edu.bjtu.xxq.dao.LoggerDao;
import edu.bjtu.xxq.model.RequestLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoggerService {
    @Autowired
    private LoggerDao loggerDao;
    public boolean saveLog(RequestLog requestLog){
        return loggerDao.save(requestLog);
    }
}
