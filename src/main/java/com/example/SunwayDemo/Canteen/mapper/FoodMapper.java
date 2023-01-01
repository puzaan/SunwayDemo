package com.example.SunwayDemo.Canteen.mapper;

import com.example.SunwayDemo.Canteen.dto.foodDto.FoodDto;
import com.example.SunwayDemo.Canteen.entity.foodCategoryEntity.FoodCategory;
import com.example.SunwayDemo.Canteen.entity.foodEntity.Food;

import java.util.ArrayList;
import java.util.List;

public class FoodMapper {

    public static FoodDto foodToFoodDto(Food food){
        FoodDto foodDto = new FoodDto();
        foodDto.setId(food.getId());
        foodDto.setFoodName(food.getFoodName());
        foodDto.setPrice(food.getPrice());
        foodDto.setQuantity(food.getQuantity());
        foodDto.setFoodType(food.getFoodType());
        foodDto.setFoodCategoryId(food.getFoodCategory().getId());
        foodDto.setFoodCategoryName(food.getFoodCategory().getFoodCategoryName());
        foodDto.setShortName(food.getFoodCategory().getShortName());
        foodDto.setDescription(food.getFoodCategory().getDescription());
        foodDto.setIsActive(food.getFoodCategory().getIsActive());

        return foodDto;


    }

    public static Food foodDtoToFood(FoodDto foodDto){
        Food food = new Food();
        food.setId(foodDto.getId());
        food.setFoodName(foodDto.getFoodName());
        food.setPrice(foodDto.getPrice());
        food.setQuantity(foodDto.getQuantity());
        food.setFoodType(foodDto.getFoodType());
        food.setFoodCategory(new FoodCategory(foodDto.getFoodCategoryId()));
        return food;

    }

    public static List<FoodDto> foodsToFoodDto(List<Food> foods){
        List<FoodDto> foodDto = new ArrayList<>();
        for(Food food: foods){
            foodDto.add(foodToFoodDto(food));
        }
        return foodDto;
    }

    public static List<Food> foodDtoToFood(List<FoodDto> foodDtos){
        List<Food> food = new ArrayList<>();
        for (FoodDto foodDto: foodDtos){
            food.add(foodDtoToFood(foodDto));
        }
        return food;
    }
}
