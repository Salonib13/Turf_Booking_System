package com.turf.controller;

import com.turf.model.User;
import com.turf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    
    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    
    @PostMapping("/login")
    public User loginUser(@RequestBody User user) {
        return userService.loginUser(user.getEmail(), user.getPassword());
    }

   
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

   
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
}