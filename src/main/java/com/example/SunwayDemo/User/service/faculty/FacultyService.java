package com.example.SunwayDemo.User.service.faculty;

import com.example.SunwayDemo.User.entity.faculty.Faculty;

import java.util.List;

public interface FacultyService  {
    Faculty create(Faculty faculty);

    List<Faculty> getAllFaculty();

    Faculty getFacultyById(Integer id);

    String deleteFacultyById(Integer id);

    Faculty updateFaculty(Integer id, Faculty faculty);

}
