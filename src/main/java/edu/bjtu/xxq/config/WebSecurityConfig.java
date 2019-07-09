package edu.bjtu.xxq.config;

import edu.bjtu.xxq.handler.LoginHandler;
import edu.bjtu.xxq.model.UserRole;
import edu.bjtu.xxq.service.UserService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final LoginHandler loginHandler;
    private final UserService userService;
    private final PasswordEncoder encoder;

    public WebSecurityConfig(LoginHandler loginHandler, UserService userService, PasswordEncoder encoder) {
        this.loginHandler = loginHandler;
        this.userService = userService;
        this.encoder = encoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(encoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http

                // 登录注册页面允许
                .authorizeRequests()
                .antMatchers("/register", "/admin/login", "/test/**")
                .permitAll()

                // 登录页面用户任意访问
                .and()
                .formLogin()
                .loginPage("/login-page.html")
                .loginProcessingUrl("/login")
                .successHandler(loginHandler)
                .failureHandler(loginHandler)
                .permitAll()

                // 管理员权限
                .and()
                .authorizeRequests()
                .antMatchers("/admin**", "/admin/**")
//                .hasRole(UserRole.ADMIN)
                .permitAll()

                // 顾客权限
                .and()
                .authorizeRequests()
                .antMatchers("/customer**",
                        "/order/**", "/order**",
                        "/cart/**", "/cart**")
//                .hasRole(UserRole.CUSTOMER)
                .permitAll()

                .and()
                .csrf().disable()
        ;
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(
                "/css/**",
                "/images/**", "/js/**",
                "/plugin/**", "/fonts/**"
        );
    }
}
