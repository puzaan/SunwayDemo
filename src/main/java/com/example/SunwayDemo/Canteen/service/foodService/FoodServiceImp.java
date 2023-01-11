package com.example.SunwayDemo.Canteen.service.foodService;

import com.example.SunwayDemo.Canteen.dto.foodDto.FoodDto;
import com.example.SunwayDemo.Canteen.entity.foodEntity.Food;
import com.example.SunwayDemo.Canteen.entity.foodCategoryEntity.FoodCategory;
import com.example.SunwayDemo.Canteen.exceptions.foodCategoryException.FoodCategoryNotFoundException;
import com.example.SunwayDemo.Canteen.exceptions.foodException.FoodNotFoundException;
import com.example.SunwayDemo.Canteen.mapper.FoodMapper;
import com.example.SunwayDemo.Canteen.repository.FoodCategoryRepository;
import com.example.SunwayDemo.Canteen.repository.FoodRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class FoodServiceImp implements FoodService {
    @Autowired
    private FoodRepository foodRepository;
    @Autowired
    private FoodCategoryRepository foodCategoryRepository;

    @Override
    public FoodDto CreateFood(FoodDto foodDto) {
        Optional<FoodCategory> foodCategory = foodCategoryRepository.findById(foodDto.getFoodCategoryId());

        if(foodCategory.isPresent()){
            Food food = FoodMapper.foodDtoToFoodList(foodDto);
            Food food1 = foodRepository.save(food);
            return FoodMapper.foodToFoodDto(food1);
        }else {
            throw new FoodCategoryNotFoundException(foodDto.getFoodCategoryId());
        }
    }

    @Override
    public List<FoodDto> getAllFood() {
        List<Food> foods = foodRepository.findAll();

        if (foods.isEmpty()) {
            throw new FoodNotFoundException("No Food found");
        } else {
            return FoodMapper.foodsToFoodDtoList(foods);
        }
    }

//    @Override
//    public Page<Food> getLimitFood(Integer page , Integer size) {
//        Pageable pageable = PageRequest.of(page, size);
//        Page<Food> foods = foodRepository.findAll(pageable);
//        return foods;
//    }

    @Override
    public FoodDto getFoodById(Integer id) {
        Optional<Food> food = foodRepository.findById(id);
        if (food.isPresent()) {
            return FoodMapper.foodToFoodDto(food.get());
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

    @Override
    public List<FoodDto> getAllFoodCategoryByShortName(String shortName) {
        List<Food> foodItemsList = foodRepository.findByFoodCategoryShortName(shortName);
        return FoodMapper.foodsToFoodDtoList(foodItemsList);
    }

    @Override
    public Map<String, List<FoodDto>> getActiveFoodCategory() {
        List<FoodCategory> foodCategoriesList = foodCategoryRepository.findFoodCategoriesByIsActive(true);

        Map<String,List<FoodDto>> foodItemsCategorized = new HashMap<>();
        //FoodCategory is data type and foodCategoriesList is array list data
        for (FoodCategory x : foodCategoriesList){

            foodItemsCategorized.put(
                    // x.getFoodCategoryName() stored in map string and
                    x.getFoodCategoryName(),
                    //this.getAllFoodCategoryByShortName(x.getShortName()) stored in list<fooddto>
                    this.getAllFoodCategoryByShortName(x.getShortName()));

        }
//        List<Food> foodList = foodRepository.findAll();
//
//        foodItemsCategorized = foodCategoriesList.stream().map(x ->
//                getFoodById(x.getId())
//                ).collect(Collectors.groupingBy(cat ->
//                        cat.getFoodCategoryName())
//        );
        return foodItemsCategorized;
    }

}
