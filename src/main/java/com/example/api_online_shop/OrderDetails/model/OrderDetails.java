package com.example.api_online_shop.OrderDetails.model;

import com.example.api_online_shop.Order.model.Order;
import com.example.api_online_shop.Product.model.Product;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity(name = "OrderDetails")
@Table(name = "orderDetails")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class OrderDetails {
    @Id
    @SequenceGenerator(name = "orderDetails_sequence", sequenceName = "orderDetails_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderDetails_sequence")
    private Long id;

    @Column(name = "quantity")
    @NotNull(message = "quantity este necessar")
    private int quantity;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;

    @Override
    public String toString() {
        return "OrderDetails{" +
                "id=" + id +
                ", quantity=" + quantity +
                '}';
    }
}
