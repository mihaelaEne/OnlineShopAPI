package com.example.api_online_shop.Product.dtos;

import com.example.api_online_shop.Product.model.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateProductResponse {
    private Product product;

    @Builder.Default
    private String message="Produs a fost creat cu succes";
}
