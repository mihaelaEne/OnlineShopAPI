package com.example.api_online_shop.Order.dtos;

import com.example.api_online_shop.Product.model.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateOrderRequest {
    private int customerId;
    private String shippingAdress;
    private String orderAdress;
    private String orderEmail;
    private List<ProductDetailsDto> productDetailsDtoList;






}
