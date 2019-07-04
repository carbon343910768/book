package edu.bjtu.xxq.dao;

import edu.bjtu.xxq.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    User findByUsername(String username);

    User findById(int id);

    void addUser(User user);
}
