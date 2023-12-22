package com.example.api_online_shop.Product.exceptions;

import static com.example.api_online_shop.System.Constants.PRODUCT_EXIST;

public class ProductExistException extends RuntimeException{
    public ProductExistException() {
        super(PRODUCT_EXIST);
    }
}
