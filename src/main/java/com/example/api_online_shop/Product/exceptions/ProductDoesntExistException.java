package com.example.api_online_shop.Product.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static com.example.api_online_shop.System.Constants.PRODUCT_DOESNT_EXIST;
@ResponseStatus(value = HttpStatus.BAD_REQUEST)

public class ProductDoesntExistException extends RuntimeException{
    public ProductDoesntExistException() {
        super(PRODUCT_DOESNT_EXIST);
    }
}
