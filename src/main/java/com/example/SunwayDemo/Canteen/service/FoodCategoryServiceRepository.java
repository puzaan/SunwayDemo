package com.example.SunwayDemo.Canteen.service;

import com.example.SunwayDemo.Canteen.entity.Food;
import com.example.SunwayDemo.Canteen.entity.FoodCategory;

import java.util.List;

public interface FoodCategoryServiceRepository {
    public FoodCategory CreateFoodCategory(FoodCategory foodcategory);
    public List<FoodCategory> getAllFoodCategory ();

    public FoodCategory getFoodCategoryById (Integer id);

    public String deleteFoodCategoryById(Integer id);

    public FoodCategory updateFoodCategoryById(Integer id, FoodCategory foodCategory);
}
