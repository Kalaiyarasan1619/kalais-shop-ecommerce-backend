package com.ecommerce.shop.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.shop.demo.modal.Products;
import com.ecommerce.shop.demo.repo.ProductsRepo;

@RestController
@RequestMapping("/api/v2/products")
public class ProductController {

    @Autowired
    private ProductsRepo repo;

    @GetMapping("/{userId}")
    public List<Products> getProductsByUserId(@PathVariable Long userId) {
        return repo.findByUserId(userId);
    }

}
