package com.example.SunwayDemo.User.mapper;

import com.example.SunwayDemo.User.dto.SubjectDTO;
import com.example.SunwayDemo.User.entity.subjects.Subjects;

import javax.security.auth.Subject;

public class SubjectMapper {

    public static Subjects subjectDTOToSubject(SubjectDTO subjectDTO){

        Subjects subjects = new Subjects();
        subjects.setId(subjectDTO.getId());
        subjects.setName(subjectDTO.getName());
        subjects.setShortName(subjectDTO.getShortName());
        subjects.setDetails(subjectDTO.getDetails());
        subjects.setCreditHrs(subjectDTO.getCreditHrs());
        return subjects;
    }
}
