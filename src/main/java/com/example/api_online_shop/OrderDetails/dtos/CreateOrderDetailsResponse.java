package com.example.api_online_shop.OrderDetails.dtos;


import com.example.api_online_shop.OrderDetails.model.OrderDetails;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateOrderDetailsResponse {
    private OrderDetails orderDetails;

    @Builder.Default
    private String message="OrderDetails a fost creat cu succes";
}
