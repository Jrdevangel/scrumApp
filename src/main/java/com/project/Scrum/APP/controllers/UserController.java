package com.project.Scrum.APP.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.Scrum.APP.models.User;
import com.project.Scrum.APP.services.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }




    

    @PutMapping(path = "{id}")
    public User updateUser(User user, Integer id){
        return userService.updateUser(user, id);
    }
}
