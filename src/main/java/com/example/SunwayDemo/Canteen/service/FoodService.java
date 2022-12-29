package com.example.SunwayDemo.Canteen.service;

import com.example.SunwayDemo.Canteen.dto.foodDto.FoodDto;
import com.example.SunwayDemo.Canteen.entity.Food;
import com.example.SunwayDemo.Canteen.entity.FoodCategory;
import com.example.SunwayDemo.Canteen.exception.foodexception.FoodCategoryNotFoundException;
import com.example.SunwayDemo.Canteen.exception.foodexception.FoodNotFoundException;
import com.example.SunwayDemo.Canteen.reopsitory.FoodCategoryRepository;
import com.example.SunwayDemo.Canteen.reopsitory.FoodRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService implements FoodServiceRepository{
    @Autowired
    private FoodRepository foodRepository;
    @Autowired
    private FoodCategoryRepository foodCategoryRepository;

    @Override
    public Food CreateFood(FoodDto foodDto) {
        Optional<FoodCategory> foodCategory = foodCategoryRepository.findById(foodDto.getFoodCategoryId());
        Food food = new Food();
        if(foodCategory.isPresent()){
            BeanUtils.copyProperties(foodDto, food);
            food.setFoodCategory(foodCategory.get());
            return foodRepository.save(food);
        }else {
            throw new FoodCategoryNotFoundException(foodDto.getFoodCategoryId());
        }
    }

    @Override
    public List<Food> getAllFood() {
        List<Food> foods = foodRepository.findAll();
        if (foods.isEmpty()) {
            throw new FoodNotFoundException("No Food found");
        } else {
            return foods;
        }
    }

    @Override
    public Food getFoodById(Integer id) {
        Optional<Food> food = foodRepository.findById(id);
        if (food.isPresent()) {
            return food.get();
        } else {
            throw new FoodNotFoundException(id);
        }
    }

    @Override
    public String deleteFoodById(Integer id) {
        if(foodRepository.findById(id).isPresent()){
            foodRepository.deleteById(id);
            return "Food deleted successfully";
        }else {
            throw  new FoodNotFoundException(id);
        }

    }

    @Override
    public Food UpdateFoodById(Integer id, FoodDto foodDto) {
        try {
            Food existingFood = foodRepository.findById(id).get();
            System.out.println(existingFood.getFoodName());
//            return existingFood;
            if(foodDto.getFoodCategoryId() != null){
//                try {
//                    FoodCategory foodCategory = foodCategoryRepository.findById(foodDto.getFoodCategoryId()).get();
//                    BeanUtils.copyProperties(foodDto, existingFood);
//                    existingFood.setFoodCategory(foodCategory);
//                    existingFood.setId(id);
//                    return foodRepository.save(existingFood);
//                }catch (Exception e){
//                    throw  new FoodCategoryNotFoundException(foodDto.getFoodCategoryId());
//                }
return null;
            }else {
                BeanUtils.copyProperties(foodDto, existingFood);
                existingFood.setId(id);
//                return foodRepository.save(existingFood);
                return existingFood;
            }

        }catch (Exception e){
            throw new FoodNotFoundException(id);
        }
    }
}
