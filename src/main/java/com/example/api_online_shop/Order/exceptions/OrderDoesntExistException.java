package com.example.api_online_shop.Order.exceptions;


import static com.example.api_online_shop.System.Constants.ORDER_DOESNT_EXIST;

public class OrderDoesntExistException extends RuntimeException{
    public OrderDoesntExistException() {
        super(ORDER_DOESNT_EXIST);
    }
}
