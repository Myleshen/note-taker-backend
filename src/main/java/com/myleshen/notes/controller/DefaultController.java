package com.myleshen.notes.controller;

import com.myleshen.notes.security.entity.UserEntity;
import com.myleshen.notes.security.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("/")
public class DefaultController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final Logger logger = LoggerFactory.getLogger(DefaultController.class);

    @Autowired
    public DefaultController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping()
    public String loadIndexPage() {
        return "Index";
    }

    @GetMapping("login")
    public String loadLoginPage(Model model) {
        UserEntity userEntity = new UserEntity();
        model.addAttribute("UserEntity", userEntity);
        return "Login/login";
    }

    @PostMapping("login_success")
    public String loadLoginSuccessPage(@CurrentSecurityContext(expression = "authentication")
                                                   Authentication authentication) {
        logger.info("User Has been Logged In " + authentication.getName());
        return "Login/LoggedIn";
    }

    @GetMapping("login_error")
    public String loadLoginErrorPage() {
        logger.warn("Login attempt has been made...");
        return "Login/login_error";
    }

    @GetMapping("signup")
    public String createSignupPage(Model model) {
        UserEntity userEntity = new UserEntity();
        model.addAttribute("UserEntity", userEntity);
        return "User/CreateUserForm";
    }

    @PostMapping("signup")
    public String createUser(@ModelAttribute("UserEntity") UserEntity userEntity) {
        if (userService.findByUserNameBoolean(userEntity.getUserName())) {
            return "User/UserNameTaken";
        }
        userEntity.setUserPass(passwordEncoder.encode(userEntity.getUserPass()));
        userEntity.setRoleList("USER");
        userEntity.setActive(true);
        userEntity.setId(UUID.randomUUID());
        this.userService.addUser(userEntity);
        logger.info("User has been created with the username: " + userEntity.getUserName());
        return "User/UserCreated";
    }

    @GetMapping("logout_success")
    public String loadLogoutSuccessPage() {
        logger.info("User has Successfully Logged out");
        return "Login/logout_success";
    }

}
