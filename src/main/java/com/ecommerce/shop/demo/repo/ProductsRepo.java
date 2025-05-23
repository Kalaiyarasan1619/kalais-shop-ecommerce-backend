package com.ecommerce.shop.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.shop.demo.modal.Products;

@Repository
public interface ProductsRepo extends JpaRepository<Products, Long> {
    // Custom query methods can be defined here if needed
    // For example, findByProductName(String productName);

    List<Products> findByUserId(Long userId);

}
