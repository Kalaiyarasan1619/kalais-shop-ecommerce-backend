package com.ecommerce.shop.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.shop.demo.modal.CustomerPurchasingOrderDetails;

@Repository
public interface CustomerPurchaseRepo extends JpaRepository<CustomerPurchasingOrderDetails, Long> {
    // Custom query methods can be defined here if needed
    // For example, to find orders by customer email:
    // List<CustomerPurchasingOrderDetails> findByCustomerEmail(String email);

}
