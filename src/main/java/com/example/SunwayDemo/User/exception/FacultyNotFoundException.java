package com.example.SunwayDemo.User.exception;

public class FacultyNotFoundException extends RuntimeException{
    public FacultyNotFoundException(String message) {
        super(message);
    }

    public FacultyNotFoundException(Integer id) {
        super("Faculty with id " + id + " not found");
    }
}
