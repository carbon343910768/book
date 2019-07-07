package edu.bjtu.xxq.dao;

import edu.bjtu.xxq.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    List<Integer> findAll(int start, int limit);

    User findByUsername(String username);

    User findById(int id);

    List<User> findById(List<Integer> id);

    void addUser(User user);
}
