package com.ecommerce.shop.demo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.shop.demo.modal.User;

@Repository
public interface UsersRepo extends JpaRepository<User, Long> {
    // This interface will automatically provide CRUD operations for Users entities
    // You can add custom query methods here if needed

    Optional<User> findByUsername(String username); // Update here

}
