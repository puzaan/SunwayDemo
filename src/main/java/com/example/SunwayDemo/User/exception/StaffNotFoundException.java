package com.example.SunwayDemo.User.exception;

public class StaffNotFoundException extends RuntimeException{
    public StaffNotFoundException(String message) {
        super(message);
    }

    public StaffNotFoundException(Integer orderId) {
        super("Staff with id " + orderId + " not found");
    }
}
