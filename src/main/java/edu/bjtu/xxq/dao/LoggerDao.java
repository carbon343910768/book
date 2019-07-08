package edu.bjtu.xxq.dao;

import edu.bjtu.xxq.model.RequestLog;
import org.springframework.stereotype.Repository;

@Repository
public interface LoggerDao {

    void save(RequestLog requestLog);

    void record(int userId, Integer[] books, int action, int weight);
}
