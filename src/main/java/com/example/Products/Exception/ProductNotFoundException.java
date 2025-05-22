package com.example.Products.Exception;


public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(String message)
    {
        super(message);
    }

}
