package com.example.campus_server.controller;

import com.example.campus_server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping(value = "/")
public class WebController {
    @Autowired
    private UserService userService;
    @RequestMapping("/tosignup")
    public String test3()
    {
        return "signup";
    }
    @RequestMapping("/signupSuccess")
    public String signup(@RequestParam("username") String username,
                         @RequestParam("password") String password,
                         @RequestParam("nickname") String nickname) {
        // Call the signup method of the userService object with the extracted parameters
        Integer ret = userService.signup(username, password, nickname);

        // Wrap the output value in an HTTP response and return it
        // return ResponseEntity.ok(ret);
        if(ret==0) {
            return "success";
        }else return "失败";

    }
}
