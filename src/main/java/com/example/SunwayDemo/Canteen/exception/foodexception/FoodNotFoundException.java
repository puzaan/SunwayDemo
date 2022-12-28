package com.example.SunwayDemo.Canteen.exception.foodexception;

public class FoodNotFoundException extends RuntimeException{

    public FoodNotFoundException(String message) {
        super(message);
    }

    public FoodNotFoundException(Integer id) {
        super("Food with id " + id + " not found");
    }

}
