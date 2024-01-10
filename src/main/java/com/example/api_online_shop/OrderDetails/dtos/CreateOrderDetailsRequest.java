package com.example.api_online_shop.OrderDetails.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateOrderDetailsRequest {
    private int orderId;
    private int productId;
    private int quantity;


}
