package com.example.campus_server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class WebController {
    @RequestMapping("signup")
    public String signup() {
        return "signup";
    }
    @RequestMapping("login")
    public String login() {
        return "login";
    }
}
