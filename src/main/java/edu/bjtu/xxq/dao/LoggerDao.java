package edu.bjtu.xxq.dao;

import edu.bjtu.xxq.model.RequestLog;
import org.springframework.stereotype.Repository;

@Repository
public interface LoggerDao {

    boolean save(RequestLog requestLog);
}
