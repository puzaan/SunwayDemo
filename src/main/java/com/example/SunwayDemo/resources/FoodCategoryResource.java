package com.example.SunwayDemo.resources;

import com.example.SunwayDemo.Canteen.controller.foodCategoryController.FoodCategoryController;
import com.example.SunwayDemo.Canteen.dto.foodCategoryDto.FoodCategoryDto;
import org.springframework.hateoas.Links;
import org.springframework.hateoas.RepresentationModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

public class FoodCategoryResource extends RepresentationModel<FoodCategoryResource> {

    public FoodCategoryDto createLinksWithFoodCategory(FoodCategoryDto foodCategoryDto) {
        final Integer id = foodCategoryDto.getId();
        return foodCategoryDto.add(createLinks(id));
    }

    public Links createLinks(Integer id) {
        return Links.of(
                linkTo(FoodCategoryController.class).withRel("foodController"),
                linkTo(FoodCategoryController.class).slash(id).withSelfRel(),
                linkTo(FoodCategoryController.class).slash(id).slash("delete").withRel("delete"),
                linkTo(FoodCategoryController.class).slash(id).slash("update").withRel("update")
        );
    }

}
