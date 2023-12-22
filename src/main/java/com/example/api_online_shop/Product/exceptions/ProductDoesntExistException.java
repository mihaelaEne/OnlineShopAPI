package com.example.api_online_shop.Product.exceptions;

import static com.example.api_online_shop.System.Constants.PRODUCT_DOESNT_EXIST;

public class ProductDoesntExistException extends RuntimeException{
    public ProductDoesntExistException() {
        super(PRODUCT_DOESNT_EXIST);
    }
}
