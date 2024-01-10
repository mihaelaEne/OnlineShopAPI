package com.example.api_online_shop.Order.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static com.example.api_online_shop.System.Constants.ORDER_DOESNT_EXIST;
@ResponseStatus(value = HttpStatus.BAD_REQUEST)

public class OrderDoesntExistException extends RuntimeException{
    public OrderDoesntExistException() {
        super(ORDER_DOESNT_EXIST);
    }
}
