package edu.bjtu.xxq.service;

import edu.bjtu.xxq.dao.LoggerDao;
import edu.bjtu.xxq.model.RequestLog;
import edu.bjtu.xxq.util.UserUtil;
import edu.bjtu.xxq.util.WeightUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoggerService {

    @Autowired
    private LoggerDao loggerDao;

    public void saveLog(RequestLog log) {
        loggerDao.save(log);
    }

    public void action(Integer bookId, int action) {
        actions(new Integer[]{bookId}, action);
    }

    public void actions(Integer[] bookId, int action) {
        Integer weight = WeightUtil.weight(action);
        Integer userId = UserUtil.getUserId();
        if (weight != null && userId != null)
            loggerDao.record(userId, bookId, action, weight);
    }
}
