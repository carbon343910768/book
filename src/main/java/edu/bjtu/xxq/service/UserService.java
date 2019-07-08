package edu.bjtu.xxq.service;

import edu.bjtu.xxq.dao.UserDao;
import edu.bjtu.xxq.model.User;
import edu.bjtu.xxq.model.UserRole;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    private final UserDao userDao;
    private final PasswordEncoder encoder;

    public UserService(UserDao userDao, PasswordEncoder encoder) {
        this.userDao = userDao;
        this.encoder = encoder;
    }

    private static final int PAGE_SIZE = 10;

    @Override
    public User loadUserByUsername(String username) {
        return userDao.findByUsername(username);
    }

    public User getUserById(int id) {
        return userDao.findById(id);
    }

    public List<User> getUsersById(Integer[] id) {
        return userDao.findUsersById(Arrays.asList(id));
    }

    public List<User> getAllUsers(int page) {
        List<User> list = new ArrayList<User>();
        for ( Integer i: userDao.findAll(page * PAGE_SIZE, PAGE_SIZE)){
            list.add(getUserById(i));
        }
        return list;
    }

    public List<Integer> getAllUsersId(int page) {
        return userDao.findAll(page * PAGE_SIZE, PAGE_SIZE);
    }

    public boolean addUser(String username, String password) {
        User user = new User(username, encoder.encode(password));
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

    public void change(String name, String phone, String email) {
        if (name == null) name = "";
        if (phone == null) phone = "";
        if (email == null) email = "";
        userDao.changeDetail(name, phone, email);
    }
}