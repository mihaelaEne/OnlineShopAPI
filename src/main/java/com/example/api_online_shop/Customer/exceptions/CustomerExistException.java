package com.example.api_online_shop.Customer.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static com.example.api_online_shop.System.Constants.CUSTOMER_EXIST;
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CustomerExistException extends RuntimeException{
    public CustomerExistException() {
        super(CUSTOMER_EXIST);
    }
}
