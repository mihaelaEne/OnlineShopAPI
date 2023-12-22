package com.example.api_online_shop.OrderDetails.exceptions;


import static com.example.api_online_shop.System.Constants.ORDER_DETAILS_EXIST;

public class OrderDetailsExistException extends RuntimeException{
    public OrderDetailsExistException() {
        super(ORDER_DETAILS_EXIST);
    }
}
