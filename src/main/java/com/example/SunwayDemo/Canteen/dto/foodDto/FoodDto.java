package com.example.SunwayDemo.Canteen.dto.foodDto;

import com.example.SunwayDemo.Canteen.entity.foodCategoryEntity.FoodCategory;
import com.example.SunwayDemo.Canteen.entity.foodEntity.Food;
import com.example.SunwayDemo.Canteen.enums.FoodType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FoodDto extends RepresentationModel<FoodDto> {
    private Integer id;
    private String foodName;
    private Integer quantity;
    private Integer price;
    private FoodType foodType;
    private Integer foodCategoryId;

    private String foodCategoryName;

    private String shortName;
    private Boolean isActive;
    private String description;

//    public FoodDto toDto(Food foodItems){
//        FoodDto foodItemsDto = FoodDto.builder()
//                .id(foodItems.getId())
//                .foodName(foodItems.getFoodName())
//                .foodCategoryId(foodItems.getFoodCategory().getId())
//                .price(foodItems.getPrice())
//                .quantity(foodItems.getQuantity())
//                .vegOrNonVeg(foodItems.getFoodType())
//                .foodCategoryName(foodItems.getFoodCategory().getFoodCategoryName())
//                .foodCategoryShortName(foodItems.getFoodCategory().getShortName())
//                .build();
//        return foodItemsDto;
//    }
//
//    public Food toEntity(FoodDto foodItemsDto){
//        Food foodItemsToBeSaved = new Food();
//        foodItemsToBeSaved.setId(foodItemsDto.getId());
//        foodItemsToBeSaved.setFoodName(foodItemsDto.getFoodName());
//        foodItemsToBeSaved.setFoodType(foodItemsDto.getFoodType(););
//        foodItemsToBeSaved.setQuantity(foodItemsDto.getQuantity());
//        foodItemsToBeSaved.setPrice(foodItemsDto.getPrice());
//        foodItemsToBeSaved.setFoodCategory(new FoodCategory(foodItemsDto.getFoodCategoryId()));
//        return foodItemsToBeSaved;
//    }

}
