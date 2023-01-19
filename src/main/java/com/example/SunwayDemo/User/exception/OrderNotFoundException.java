package com.example.SunwayDemo.User.exception;

public class OrderNotFoundException extends RuntimeException{
    public OrderNotFoundException(String message) {
        super(message);
    }

    public OrderNotFoundException(Integer orderId) {
        super("Order with id " + orderId + " not found");
    }
}
