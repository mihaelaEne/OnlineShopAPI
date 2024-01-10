package com.example.api_online_shop.Customer.dtos;

import com.example.api_online_shop.Customer.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateCustomerResponse {

    private Customer customer;

    @Builder.Default
    private String message="Clientul a fost creat cu succes";
}
