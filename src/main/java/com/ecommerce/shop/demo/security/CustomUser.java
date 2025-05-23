package com.ecommerce.shop.demo.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.ecommerce.shop.demo.modal.User;
import com.ecommerce.shop.demo.repo.UsersRepo;

@Component
public class CustomUser implements UserDetailsService {

    @Autowired
    private UsersRepo repo;

    @Autowired
    private PasswordEncoder passwordEncoder; // Inject PasswordEncoder

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> o = repo.findByUsername(username);

        if (o.isEmpty()) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        User user = o.get();

        // Convert your custom User to Spring Security UserDetails
        UserDetails userDetails = org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword()) // Don't encode again
                .roles("USER")
                .build();

        return userDetails; // Return UserDetails object
    }
}
