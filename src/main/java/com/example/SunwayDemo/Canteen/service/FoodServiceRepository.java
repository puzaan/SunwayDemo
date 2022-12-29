package com.example.SunwayDemo.Canteen.service;

import com.example.SunwayDemo.Canteen.dto.foodDto.FoodDto;
import com.example.SunwayDemo.Canteen.entity.Food;

import java.util.List;

public interface FoodServiceRepository {
    public Food CreateFood(FoodDto foodDto);
    public List<Food> getAllFood ();

    public Food getFoodById (Integer id);

    public String deleteFoodById(Integer id);

    public Food UpdateFoodById(Integer id, FoodDto foodDto);

}
