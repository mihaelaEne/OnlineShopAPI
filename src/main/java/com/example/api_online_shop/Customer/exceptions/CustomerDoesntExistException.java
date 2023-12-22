package com.example.api_online_shop.Customer.exceptions;


import static com.example.api_online_shop.System.Constants.CUSTOMER_DOESNT_EXIST;

public class CustomerDoesntExistException extends RuntimeException{
    public CustomerDoesntExistException() {
        super(CUSTOMER_DOESNT_EXIST);
    }
}
