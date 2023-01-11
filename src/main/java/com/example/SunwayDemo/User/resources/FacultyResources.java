package com.example.SunwayDemo.User.resources;

import com.example.SunwayDemo.Canteen.controller.foodCategoryController.FoodCategoryController;
import com.example.SunwayDemo.User.controller.facultyController.FacultyController;
import com.example.SunwayDemo.User.entity.faculty.Faculty;
import org.springframework.hateoas.Links;
import org.springframework.hateoas.RepresentationModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

public class FacultyResources extends RepresentationModel<FacultyResources> {

    public Faculty CreateLinkWithFaculty(Faculty faculty){
        final Integer id = faculty.getId();
        return faculty.add(createLinks(id));
    }

    public Links createLinks(Integer id) {
        return Links.of(
                linkTo(FacultyController.class).withRel("list"),
                linkTo(FacultyController.class).slash(id).withSelfRel(),
                linkTo(FacultyController.class).slash(id).slash("delete").withRel("delete"),
                linkTo(FacultyController.class).slash(id).slash("update").withRel("update")
        );
    }

}
