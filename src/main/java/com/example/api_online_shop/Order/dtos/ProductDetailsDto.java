package com.example.api_online_shop.Order.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@SuperBuilder
public class ProductDetailsDto {
  private  Long productId;
  private int cantitate;

}
