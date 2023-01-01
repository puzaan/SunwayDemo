package com.example.SunwayDemo.Canteen.mapper;

import com.example.SunwayDemo.Canteen.dto.foodCategoryDto.FoodCategoryDto;
import com.example.SunwayDemo.Canteen.entity.foodCategoryEntity.FoodCategory;
import com.example.SunwayDemo.resources.FoodCategoryResource;

import java.util.ArrayList;
import java.util.List;

public class FoodCategoryMapper {

    public static FoodCategoryDto foodCategoryToFoodCategoryDto(FoodCategory foodCategory){

        FoodCategoryDto foodCategoryDto = new FoodCategoryDto();
        foodCategoryDto.setId(foodCategory.getId());
        foodCategoryDto.setFoodCategoryName(foodCategory.getFoodCategoryName());
        foodCategoryDto.setIsActive(foodCategory.getIsActive());
        foodCategoryDto.setShortName(foodCategory.getShortName());
        foodCategoryDto.setDescription(foodCategory.getDescription());
        return foodCategoryDto;


    }

    public static FoodCategory foodCategoryDtoToFoodCategory(FoodCategoryDto foodCategoryDto){
        FoodCategory foodCategory = new FoodCategory();
        foodCategory.setId(foodCategoryDto.getId());
        foodCategory.setFoodCategoryName(foodCategoryDto.getFoodCategoryName());
        foodCategory.setShortName(foodCategoryDto.getShortName());
        foodCategory.setIsActive(foodCategoryDto.getIsActive());
        foodCategory.setDescription(foodCategoryDto.getDescription());
        return foodCategory;

    }

    public static List<FoodCategoryDto> foodCategoryToFoodCategoryDtoList(List<FoodCategory> foodCategories){
        List<FoodCategoryDto> foodCategoryDtos = new ArrayList<>();
        for(FoodCategory foodCategory: foodCategories){
            foodCategoryDtos.add(new FoodCategoryResource().createLinksWithFoodCategory(foodCategoryToFoodCategoryDto(foodCategory)));
        }
        return foodCategoryDtos;
    }

    public static List<FoodCategory> foodCategoryDtoToFoodCategoryList(List<FoodCategoryDto> foodCategoryDtos){
        List<FoodCategory> foodCategories = new ArrayList<>();
        for (FoodCategoryDto foodCategoryDto: foodCategoryDtos){
            foodCategories.add(foodCategoryDtoToFoodCategory(foodCategoryDto));
        }
        return foodCategories;
    }
}
