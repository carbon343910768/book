package com.bjtu.xxq.config;

import com.bjtu.xxq.handler.LoginHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by yangyibo on 17/1/18.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private LoginHandler loginHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(customUserService()).passwordEncoder(encoder);
        auth.inMemoryAuthentication()
                .passwordEncoder(encoder)
                .withUser("test")
                .password(encoder.encode("111111"))
                .roles("CUSTOMER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // 任何请求,登录后可以访问
                .authorizeRequests()
                .anyRequest()
                .authenticated()

                // 登录页面用户任意访问
                .and()
                .formLogin()
                .loginProcessingUrl("/login")
                .successHandler(loginHandler)
                .failureHandler(loginHandler)
                .permitAll()

                // 管理员权限
                .and()
                .authorizeRequests()
                .antMatchers("/admin/**")
                .hasRole("ADMIN")

                // 管理员登录界面
                .and()
                .authorizeRequests()
                .antMatchers("/admin/login")
                .permitAll()

//                .and()
//                .authorizeRequests()
//                .antMatchers(
//                        "/js/**",
//                        "/css/**",
//                        "/img/**",
//                        "/login/**")
//                .permitAll()

                .and()
                .csrf().disable()
        ;
    }

    private PasswordEncoder encoder = new BCryptPasswordEncoder();

    @Bean
    public PasswordEncoder passwordEncoder() {
        return encoder;
    }
}
