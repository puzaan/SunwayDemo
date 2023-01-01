package com.example.SunwayDemo.Canteen.dto.foodCategoryDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.Links;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FoodCategoryDto extends RepresentationModel<FoodCategoryDto> implements Serializable {

    private Integer id;

    private String foodCategoryName;

    private String shortName;

    private Boolean isActive;

    private String description;

    public void setResource(Links resource) {
        this.add(resource);
    }

}
