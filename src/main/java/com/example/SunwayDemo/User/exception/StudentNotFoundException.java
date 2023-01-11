package com.example.SunwayDemo.User.exception;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(String message) {
        super(message);
    }

    public StudentNotFoundException(Integer id) {
        super("Student with id " + id + " not found");
    }
}
