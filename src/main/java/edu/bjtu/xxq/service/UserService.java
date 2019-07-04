package edu.bjtu.xxq.service;

import edu.bjtu.xxq.dao.UserDao;
import edu.bjtu.xxq.model.User;
import edu.bjtu.xxq.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private final UserDao userDao;
    private final PasswordEncoder encoder;

    public UserService(UserDao userDao, PasswordEncoder encoder) {
        this.userDao = userDao;
        this.encoder = encoder;
    }

    @Override
    public User loadUserByUsername(String username) {
        return userDao.findByUsername(username);
    }

    public User loadUserById(int id) {
        return userDao.findById(id);
    }

    public boolean addUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRole(UserRole.CUSTOMER);
        userDao.addUser(user);
        return true;
    }

    public boolean addAdmin(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRole(UserRole.ADMIN);
        userDao.addUser(user);
        return true;
    }
}