package com.ecommerce.shop.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.shop.demo.modal.User;
import com.ecommerce.shop.demo.security.JwtUtil;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager auth;

    @Autowired
    private JwtUtil jwt;

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody User user) {

        try {
            Authentication authentication = auth
                    .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),
                            user.getPassword()));

            UserDetails details = (UserDetails) authentication.getPrincipal();

            String token = jwt.generateToken(details);

            return ResponseEntity.ok(Map.of("token", token));
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", "Invalid UserName or PassWord"));
        }

    }
}
