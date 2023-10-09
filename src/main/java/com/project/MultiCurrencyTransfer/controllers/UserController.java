package com.project.MultiCurrencyTransfer.controllers;
import com.project.MultiCurrencyTransfer.repositories.UserRepository;
import com.project.MultiCurrencyTransfer.entities.User;
import com.project.MultiCurrencyTransfer.services.user.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/user/")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping("register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        System.out.println(user);
        return new ResponseEntity<>(userService.registerUser(user), HttpStatus.CREATED);
    }

    // PUT - update more than one property
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody User updatedUser) {
        updatedUser.setUserId(id);
        User u = userService.updateUser(updatedUser);
        return ResponseEntity.ok(u);
    }


}
