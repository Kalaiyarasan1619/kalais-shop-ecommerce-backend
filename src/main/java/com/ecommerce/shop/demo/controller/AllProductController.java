package com.ecommerce.shop.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.shop.demo.modal.All_Product;
import com.ecommerce.shop.demo.repo.AllProductsRepo;

@RestController
@RequestMapping("/api/v2/")
public class AllProductController {

    @Autowired
    private AllProductsRepo repo;

    @GetMapping("/allproduct")
    public List<All_Product> getall() {
        return repo.findAll();
    }

}
