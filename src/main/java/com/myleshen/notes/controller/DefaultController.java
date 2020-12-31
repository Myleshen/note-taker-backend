package com.myleshen.notes.controller;

import com.myleshen.notes.security.entity.UserEntity;
import com.myleshen.notes.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class DefaultController {

    private final UserService userService;

    @Autowired
    public DefaultController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String loadIndexPage() {
        return "Index";
    }

    @GetMapping("login")
    public String loadLoginPage() {
        return "login";
    }

    @GetMapping("login_error")
    public String loadLoginErrorPage() {
        return "login_error";
    }

    @GetMapping("signup")
    public String createSignupPage(Model model) {
        UserEntity userEntity = new UserEntity();
        model.addAttribute("UserEntity", userEntity);
        return "User/CreateUserForm";
    }

    @PostMapping("signup")
    public String createUser(@ModelAttribute("UserEntity") UserEntity userEntity) {
        this.userService.addUser(userEntity);
        return "User/UserCreated";
    }

}
