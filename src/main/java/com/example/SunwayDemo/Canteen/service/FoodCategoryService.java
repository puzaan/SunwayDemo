package com.example.SunwayDemo.Canteen.service;

import com.example.SunwayDemo.Canteen.entity.FoodCategory;
import com.example.SunwayDemo.Canteen.exception.foodexception.FoodCategoryNotFoundException;
import com.example.SunwayDemo.Canteen.reopsitory.FoodCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodCategoryService implements FoodCategoryServiceRepository{
    @Autowired
    private FoodCategoryRepository foodCategoryRepository;

    @Override
    public FoodCategory CreateFoodCategory(FoodCategory foodcategory) {
        return foodCategoryRepository.save(foodcategory);
    }

    @Override
    public List<FoodCategory> getAllFoodCategory() {
        List<FoodCategory> foodCategory = foodCategoryRepository.findAll();
        if(foodCategory.isEmpty()){
            throw new FoodCategoryNotFoundException("Not found any food category");
        }else{
            return foodCategory;
        }
    }

    @Override
    public FoodCategory getFoodCategoryById(Integer id) {
        Optional<FoodCategory> foodCategory = foodCategoryRepository.findById(id);
        if(foodCategory.isPresent()){
            return foodCategory.get();
        }else {
            throw new FoodCategoryNotFoundException(id);
        }
    }

    @Override
    public String deleteFoodCategoryById(Integer id) {
        if(foodCategoryRepository.findById(id).isPresent()){
            foodCategoryRepository.deleteById(id);
            return "Food  category deleted successfully";
        }else{
            throw new FoodCategoryNotFoundException(id);
        }
    }

    @Override
    public FoodCategory updateFoodCategoryById(Integer id, FoodCategory foodCategory) {
        Optional<FoodCategory> foodCategory1 = foodCategoryRepository.findById(id);
        if(foodCategory1.isPresent()){
            foodCategory.setId(id);
            return foodCategoryRepository.save(foodCategory);
        }else{
         throw new FoodCategoryNotFoundException(id);
        }
    }
}
