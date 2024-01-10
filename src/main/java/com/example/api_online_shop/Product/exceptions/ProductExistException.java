package com.example.api_online_shop.Product.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static com.example.api_online_shop.System.Constants.PRODUCT_EXIST;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ProductExistException extends RuntimeException{
    public ProductExistException() {
        super(PRODUCT_EXIST);
    }
}
