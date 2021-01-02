package com.myleshen.notes.security.controller;

import com.myleshen.notes.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityController extends WebSecurityConfigurerAdapter {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SecurityController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().ignoringAntMatchers("/api");

        http.authorizeRequests()
                .antMatchers("/api").hasRole("API_USER")
                .antMatchers("/notes").hasRole("USER")
                .antMatchers("/signup").permitAll()
                .antMatchers("/login").permitAll()
                .and().formLogin()
                    .loginPage("/login")
                    .usernameParameter("userName")
                    .passwordParameter("userPass")
                    .successForwardUrl("/login_success")
                    .failureUrl("/login_error")
                    .permitAll()
                .and().logout()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/logout_success")
                    .permitAll();
    }

}
