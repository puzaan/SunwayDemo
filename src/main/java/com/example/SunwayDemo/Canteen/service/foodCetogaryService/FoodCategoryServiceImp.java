package com.example.SunwayDemo.Canteen.service.foodCetogaryService;

import com.example.SunwayDemo.Canteen.dto.foodCategoryDto.FoodCategoryDto;
import com.example.SunwayDemo.Canteen.entity.foodCategoryEntity.FoodCategory;
import com.example.SunwayDemo.Canteen.exception.foodexception.foodCategoryException.FoodCategoryNotFoundException;
import com.example.SunwayDemo.Canteen.mapper.FoodCategoryMapper;
import com.example.SunwayDemo.Canteen.reopsitory.FoodCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodCategoryServiceImp implements FoodCategoryService {
    @Autowired
    private FoodCategoryRepository foodCategoryRepository;

    @Override
    public FoodCategoryDto CreateFoodCategory(FoodCategoryDto foodCategoryDto) {
        FoodCategory foodCategory = FoodCategoryMapper.foodCategoryDtoToFoodCategory(foodCategoryDto);
        foodCategoryRepository.save(foodCategory);
        return FoodCategoryMapper.foodCategoryToFoodCategoryDto(foodCategory);
    }

    @Override
    public List<FoodCategoryDto> getAllFoodCategory() {
        List<FoodCategory> foodCategory = foodCategoryRepository.findAll();
        if(foodCategory.isEmpty()){
            throw new FoodCategoryNotFoundException("Not found any food category");
        }else{
            return FoodCategoryMapper.foodCategoryToFoodCategoryDtoList(foodCategory);
        }
    }

    @Override
    public FoodCategoryDto getFoodCategoryById(Integer id) {
        Optional<FoodCategory> foodCategory = foodCategoryRepository.findById(id);
        if(foodCategory.isPresent()){
            return FoodCategoryMapper.foodCategoryToFoodCategoryDto(foodCategory.get());
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
    public FoodCategoryDto updateFoodCategoryById(Integer id, FoodCategoryDto foodCategoryDto) {
        Optional<FoodCategory> foodCategoryDto1 = foodCategoryRepository.findById(id);
        if(foodCategoryDto1.isPresent()){
            foodCategoryDto.setId(id);

            FoodCategory foodCategory = foodCategoryRepository.save(FoodCategoryMapper.foodCategoryDtoToFoodCategory(foodCategoryDto));
            return FoodCategoryMapper.foodCategoryToFoodCategoryDto(foodCategory);
        }else{
         throw new FoodCategoryNotFoundException(id);
        }
    }
}
