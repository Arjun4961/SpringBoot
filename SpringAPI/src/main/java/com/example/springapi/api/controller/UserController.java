package com.example.springapi.api.controller;

import com.example.springapi.api.model.User;
import com.example.springapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user") // Base URL for all user-related endpoints
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // GET endpoint to retrieve a user by ID
    @GetMapping("/{id}")
    public User getUser(@PathVariable Integer id) {
        Optional<User> user = userService.getUser(id);
        return user.orElse(null);
    }

    // POST endpoint to create a new user
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    // PUT endpoint to update an existing user
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Integer id, @RequestBody User updatedUser) {
        return userService.updateUser(id, updatedUser);
    }

    // DELETE endpoint to delete a user by ID
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Integer id) {
        boolean isDeleted = userService.deleteUser(id);
        return isDeleted ? "User deleted successfully" : "User not found";
    }
}