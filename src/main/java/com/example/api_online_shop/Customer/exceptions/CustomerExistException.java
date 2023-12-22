package com.example.api_online_shop.Customer.exceptions;


import static com.example.api_online_shop.System.Constants.CUSTOMER_EXIST;

public class CustomerExistException extends RuntimeException{
    public CustomerExistException() {
        super(CUSTOMER_EXIST);
    }
}
