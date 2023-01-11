package com.example.SunwayDemo.User.exception;

public class SubjectNotFoundException extends RuntimeException{
    public SubjectNotFoundException(String message){
        super(message);
    }

    public SubjectNotFoundException(Integer id){
        super("Subject with id: " + id + "not found");
    }
}
