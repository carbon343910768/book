package edu.bjtu.xxq.dao;

import edu.bjtu.xxq.model.SysLog;
import org.springframework.stereotype.Repository;

@Repository
public interface SysLogDao {

    boolean save(SysLog sysLog);
}
