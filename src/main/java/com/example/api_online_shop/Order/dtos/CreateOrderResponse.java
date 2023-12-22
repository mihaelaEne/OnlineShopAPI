package com.example.api_online_shop.Order.dtos;


import com.example.api_online_shop.Order.model.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateOrderResponse {
    private Order order;

    @Builder.Default
    private String message="Orderul a fost creat cu succes";
}
