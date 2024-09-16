package com.project.Scrum.APP.controllers;

import com.project.Scrum.APP.models.User;
import com.project.Scrum.APP.services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
    }

    @PutMapping(path = "{id}")
    public User updateUser(@RequestBody User user, @PathVariable Integer id){
        return userService.updateUser(user, id);
    }
}
