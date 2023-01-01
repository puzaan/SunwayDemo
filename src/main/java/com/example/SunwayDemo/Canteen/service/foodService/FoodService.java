package com.example.SunwayDemo.Canteen.service.foodService;

import com.example.SunwayDemo.Canteen.dto.foodDto.FoodDto;
import com.example.SunwayDemo.Canteen.entity.foodEntity.Food;
import org.springframework.data.domain.Page;

import java.util.List;

public interface FoodService {
     FoodDto CreateFood(FoodDto foodDto);
     List<FoodDto> getAllFood ();

//     Page<Food> getLimitFood(Integer page, Integer size);

     FoodDto getFoodById (Integer id);

     String deleteFoodById(Integer id);

     Food UpdateFoodById(Integer id, FoodDto foodDto);

}
