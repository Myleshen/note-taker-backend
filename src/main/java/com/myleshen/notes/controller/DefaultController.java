package com.myleshen.notes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class DefaultController {

    @GetMapping("index")
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

}
