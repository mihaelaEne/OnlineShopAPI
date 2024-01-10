package com.example.api_online_shop.OrderDetails.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static com.example.api_online_shop.System.Constants.ORDER_DETAILS_EXIST;
@ResponseStatus(value = HttpStatus.BAD_REQUEST)

public class OrderDetailsExistException extends RuntimeException{
    public OrderDetailsExistException() {
        super(ORDER_DETAILS_EXIST);
    }
}
