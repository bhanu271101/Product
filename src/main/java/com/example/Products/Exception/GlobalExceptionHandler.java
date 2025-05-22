package com.example.Products.Exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ProblemDetail handleProductNotFoundException(ProductNotFoundException productNotFoundException)
    {
        return ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(404), productNotFoundException.getMessage());
    }

}
