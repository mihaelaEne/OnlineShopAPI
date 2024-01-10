package com.example.api_online_shop.Product.exceptions;

import static com.example.api_online_shop.System.Constants.NO_UPDATE;

public class NoUpdateException extends RuntimeException{
    public NoUpdateException() {
        super(NO_UPDATE);
    }
}
