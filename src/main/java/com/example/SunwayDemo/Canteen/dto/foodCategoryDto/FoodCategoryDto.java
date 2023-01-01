package com.example.SunwayDemo.Canteen.dto.foodCategoryDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FoodCategoryDto {

    private Integer id;

    private String foodCategoryName;

    private String shortName;

    private Boolean isActive;

    private String description;

}
