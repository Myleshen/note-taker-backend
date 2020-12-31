package com.myleshen.notes.controller;


import com.myleshen.notes.security.entity.UserEntity;
import com.myleshen.notes.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public String createUser(@RequestBody UserEntity userEntity) {
        this.userService.addUser(userEntity);
        return "User/UserCreated";
    }

}
