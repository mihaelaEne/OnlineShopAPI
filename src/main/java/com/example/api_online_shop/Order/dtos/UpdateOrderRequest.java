package com.example.api_online_shop.Order.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateOrderRequest {
    private int customerId=0;
    private int ammount=0;
    private String shippingAdress="";
    private String orderAdress="";
    private String orderEmail="";
    private String orderStatus="";
}
