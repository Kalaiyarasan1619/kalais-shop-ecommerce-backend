package com.ecommerce.shop.demo.modal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long product_id; // <-- Required to avoid error

    private String product_name;
    private int product_quantity;
    private int total_products_price;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    @JsonIgnore
    private CustomerPurchasingOrderDetails order;

    private Long userId;

    private Boolean order_status;

    @Transient
    private Long order_id;

    @PostLoad
    @PostPersist
    @PostUpdate
    public void fillOrderId() {
        if (order != null) {
            this.order_id = order.getOrder_id();
        }
    }
}
