package com.ecommerce.shop.demo.modal;

import java.util.List;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer_purchasing_order_details")
public class CustomerPurchasingOrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customer_name;
    private String customer_email;
    private String customer_phone;
    private String customer_address;

    @Column(unique = true)
    private Long order_id;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Products> products;
}
