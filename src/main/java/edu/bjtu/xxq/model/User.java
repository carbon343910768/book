package edu.bjtu.xxq.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class User implements UserDetails {

    private String id;//账号
    private String username;//用户名
    private String password;//密码
    private List<GrantedAuthority> role = new ArrayList<>(1);

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public List<? extends GrantedAuthority> getAuthorities() {
        return role;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getId() {
        return id;
    }

    public User setId(String id) {
        this.id = id;
        return this;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getRole() {
        if (role.isEmpty())
            return null;
        return role.get(0).getAuthority();
    }

    public User setRole(String role) {
        this.role.clear();
        if (StringUtils.hasText(role))
            this.role.add(new SimpleGrantedAuthority("ROLE_" + role));
        return this;
    }
}
