package com.example.api_online_shop.Customer.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateCustomerRequest {
    private String email;
    private String password;
    private String fullName;
    private String billingAdress;
    private String defaultShipping;
    private String country;
    private String phone;
}
