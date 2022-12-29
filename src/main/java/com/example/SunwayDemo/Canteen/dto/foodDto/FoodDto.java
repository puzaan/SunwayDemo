package com.example.SunwayDemo.Canteen.dto.foodDto;

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
    private String foodName;
    private Integer quantity;
    private Integer price;
    private FoodType foodType;
    private Integer foodCategoryId;
}
