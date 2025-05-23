package com.ecommerce.shop.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.shop.demo.modal.User;
import com.ecommerce.shop.demo.repo.UsersRepo;

@RestController
@RequestMapping("/api/v2/user")
public class UserController {

    @Autowired
    private UsersRepo repo;

    @Autowired
    private PasswordEncoder pwd;

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {

        user.setPassword(pwd.encode(user.getPassword()));

        User savedUser = repo.save(user);
        return ResponseEntity.ok(savedUser);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable long id) {
        return repo.findById(id).orElse(null);
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return repo.findAll();
    }

}
