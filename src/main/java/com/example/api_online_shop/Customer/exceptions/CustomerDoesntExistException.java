package com.example.api_online_shop.Customer.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static com.example.api_online_shop.System.Constants.CUSTOMER_DOESNT_EXIST;
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CustomerDoesntExistException extends RuntimeException{
    public CustomerDoesntExistException() {
        super(CUSTOMER_DOESNT_EXIST);
    }
}
