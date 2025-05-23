package com.ecommerce.shop.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.shop.demo.modal.CustomerPurchasingOrderDetails;
import com.ecommerce.shop.demo.repo.CustomerPurchaseRepo;

@RestController
@RequestMapping("/api/v2/customer-purchase")
public class CustomerPurchaseController {

    @Autowired
    private CustomerPurchaseRepo repo;

    @PostMapping("/insert")
    public CustomerPurchasingOrderDetails insert(@RequestBody CustomerPurchasingOrderDetails order) {

        // 🔁 Very important: set parent reference to each product
        if (order.getProducts() != null) {
            order.getProducts().forEach(product -> product.setOrder(order));
        }

        return repo.save(order);
    }

}
