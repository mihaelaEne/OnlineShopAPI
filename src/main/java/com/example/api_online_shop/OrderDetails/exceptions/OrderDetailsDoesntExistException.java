package com.example.api_online_shop.OrderDetails.exceptions;


import static com.example.api_online_shop.System.Constants.ORDER_DETAILS_DOESNT_EXIST;

public class OrderDetailsDoesntExistException extends RuntimeException{
    public OrderDetailsDoesntExistException() {
        super(ORDER_DETAILS_DOESNT_EXIST);
    }
}
