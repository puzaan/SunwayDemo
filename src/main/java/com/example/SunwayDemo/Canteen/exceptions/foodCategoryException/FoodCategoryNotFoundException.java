package com.example.SunwayDemo.Canteen.exceptions.foodCategoryException;

public class FoodCategoryNotFoundException extends RuntimeException{
    public FoodCategoryNotFoundException(String message) {
        super(message);
    }

    public FoodCategoryNotFoundException(Integer id) {
        super("Food category with id " + id + " not found");
    }
}
