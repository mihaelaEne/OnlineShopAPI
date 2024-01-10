package com.example.api_online_shop.OrderDetails.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateOrderDetailsRequest {
    private int orderId=0;
    private int productId=0;
    private int quantity=0;

}
