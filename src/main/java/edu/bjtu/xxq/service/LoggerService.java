package edu.bjtu.xxq.service;

import edu.bjtu.xxq.dao.LoggerDao;
import edu.bjtu.xxq.model.RequestLog;
import edu.bjtu.xxq.util.UserUtil;
import edu.bjtu.xxq.util.WeightUtil;
import org.apache.tomcat.util.threads.ThreadPoolExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

@Service
public class LoggerService {

    @Autowired
    private LoggerDao loggerDao;
    private Executor executor = new ThreadPoolExecutor(4, 4, 1, TimeUnit.HOURS, new LinkedBlockingDeque<>());

    public void saveLog(RequestLog log) {
        executor.execute(() -> loggerDao.save(log));
    }

    public void action(Integer bookId, int action) {
        actions(new Integer[]{bookId}, action);
    }

    public void actions(Integer[] bookId, int action) {
        Integer weight = WeightUtil.weight(action);
        Integer userId = UserUtil.getUserId();
        if (weight != null && userId != null)
            executor.execute(() -> loggerDao.record(userId, bookId, action, weight));
    }
}
