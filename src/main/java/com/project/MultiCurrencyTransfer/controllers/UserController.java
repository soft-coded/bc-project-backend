package com.project.MultiCurrencyTransfer.controllers;

import com.project.MultiCurrencyTransfer.entities.Account;
import com.project.MultiCurrencyTransfer.repositories.UserRepository;
import com.project.MultiCurrencyTransfer.entities.User;
import com.project.MultiCurrencyTransfer.services.user.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/user/")
public class UserController {
    @Autowired
    private UserService userService;

    //    Controller Mapping to get all users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    //    Controller Mapping for register
    @PostMapping("register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        System.out.println(user);
        return new ResponseEntity<>(userService.registerUser(user), HttpStatus.CREATED);
    }

    // Controller Mapping to update a user based on UserId
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody User updatedUser) {
        updatedUser.setUserId(id);
        User u = userService.updateUser(updatedUser);
        System.out.println(updatedUser);
        return ResponseEntity.ok(u);
    }

    //    Get user based on ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable String id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }
}
