package com.example.SunwayDemo.Canteen.dto.foodDto;

import com.example.SunwayDemo.Canteen.enums.FoodType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FoodDto extends RepresentationModel<FoodDto> implements Serializable {
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

}
