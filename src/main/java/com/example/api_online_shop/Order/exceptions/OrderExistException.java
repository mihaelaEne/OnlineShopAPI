package com.example.api_online_shop.Order.exceptions;


import static com.example.api_online_shop.System.Constants.ORDER_EXIST;

public class OrderExistException extends RuntimeException{
    public OrderExistException() {
        super(ORDER_EXIST);
    }
}
