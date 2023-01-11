package com.example.SunwayDemo.User.service.student;

import com.example.SunwayDemo.User.dto.StudentDTO;
import com.example.SunwayDemo.User.dto.SubjectDTO;
import com.example.SunwayDemo.User.entity.subjects.Subjects;

import java.util.List;

public interface StudentService {
    StudentDTO create(StudentDTO studentDTO);

    List<StudentDTO> getAll();

    StudentDTO getById(Integer id);

    String deleteById(Integer id);

    StudentDTO updateById(Integer id, StudentDTO studentDTO);
}
