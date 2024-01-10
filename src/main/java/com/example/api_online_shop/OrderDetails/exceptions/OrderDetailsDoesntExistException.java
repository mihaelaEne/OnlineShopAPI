package com.example.api_online_shop.OrderDetails.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static com.example.api_online_shop.System.Constants.ORDER_DETAILS_DOESNT_EXIST;
@ResponseStatus(value = HttpStatus.BAD_REQUEST)

public class OrderDetailsDoesntExistException extends RuntimeException{
    public OrderDetailsDoesntExistException() {
        super(ORDER_DETAILS_DOESNT_EXIST);
    }
}
