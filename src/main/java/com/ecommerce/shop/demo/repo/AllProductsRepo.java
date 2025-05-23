package com.ecommerce.shop.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.shop.demo.modal.All_Product;

@Repository
public interface AllProductsRepo extends JpaRepository<All_Product, Long> {
    // This interface will automatically provide CRUD operations for All_Product
    // entities
    // You can add custom query methods here if needed

}
