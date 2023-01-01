package com.example.SunwayDemo.Canteen.service.foodCetogaryService;

import com.example.SunwayDemo.Canteen.dto.foodCategoryDto.FoodCategoryDto;
import com.example.SunwayDemo.Canteen.entity.foodCategoryEntity.FoodCategory;

import java.util.List;

public interface FoodCategoryService {
     FoodCategoryDto CreateFoodCategory(FoodCategoryDto foodCategoryDto);
     List<FoodCategoryDto> getAllFoodCategory ();

     FoodCategoryDto getFoodCategoryById (Integer id);

     String deleteFoodCategoryById(Integer id);

     FoodCategoryDto updateFoodCategoryById(Integer id, FoodCategoryDto foodCategoryDto);
}
