package edu.bjtu.xxq.dao;

import edu.bjtu.xxq.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    User findByUserName(String username);

}
