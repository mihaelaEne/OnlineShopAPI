package com.example.api_online_shop.Order.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static com.example.api_online_shop.System.Constants.ORDER_EXIST;
@ResponseStatus(value = HttpStatus.BAD_REQUEST)

public class OrderExistException extends RuntimeException{
    public OrderExistException() {
        super(ORDER_EXIST);
    }
}
