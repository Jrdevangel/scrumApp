package com.project.Scrum.APP.controllers;

import com.project.Scrum.APP.services.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {
    private UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }
}
