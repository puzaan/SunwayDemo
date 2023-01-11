package com.example.SunwayDemo.User.resources;

import com.example.SunwayDemo.User.controller.facultyController.FacultyController;
import com.example.SunwayDemo.User.controller.subjectController.SubjectController;
import com.example.SunwayDemo.User.entity.faculty.Faculty;
import com.example.SunwayDemo.User.entity.subjects.Subjects;
import org.springframework.hateoas.Links;
import org.springframework.hateoas.RepresentationModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

public class SubjectResources extends RepresentationModel<SubjectResources>  {
    public Subjects CreateLinkWithSubject(Subjects subjects){
        final Integer id = subjects.getId();
        return subjects.add(createLinks(id));
    }

    public Links createLinks(Integer id) {
        return Links.of(
                linkTo(SubjectController.class).withRel("list"),
                linkTo(SubjectController.class).slash(id).withSelfRel(),
                linkTo(SubjectController.class).slash(id).slash("delete").withRel("delete"),
                linkTo(SubjectController.class).slash(id).slash("update").withRel("update")
        );
    }
}
