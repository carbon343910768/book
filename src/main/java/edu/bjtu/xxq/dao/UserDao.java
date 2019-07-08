package edu.bjtu.xxq.dao;

import edu.bjtu.xxq.model.CustomerDetail;
import edu.bjtu.xxq.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    List<Integer> findAll(int start, int limit);

    User findByUsername(String username);

    User findById(int id);

    List<User> findUsersById(List<Integer> id);

    CustomerDetail findCustomerById(int id);

    CustomerDetail findCustomerByUsername(String username);

    List<CustomerDetail> findCustomer(int start, int limit);

    void addUser(User user);

    void changeDetail(int userId, String name, String phone, String email);
}
