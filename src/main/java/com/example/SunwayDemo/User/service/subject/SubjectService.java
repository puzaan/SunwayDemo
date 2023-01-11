package com.example.SunwayDemo.User.service.subject;

import com.example.SunwayDemo.User.dto.SubjectDTO;
import com.example.SunwayDemo.User.entity.faculty.Faculty;
import com.example.SunwayDemo.User.entity.subjects.Subjects;

import java.util.List;

public interface SubjectService {
    SubjectDTO create(SubjectDTO subjectDTO);

    List<Subjects> getAllSubject();

    Subjects getSubjectById(Integer id);

    String deleteSubjectById(Integer id);

    Subjects updateSubject(Integer id, Subjects subjects);
}
