package com.example.SunwayDemo.User.mapper;

import com.example.SunwayDemo.User.dto.StudentDTO;
import com.example.SunwayDemo.User.entity.faculty.Faculty;
import com.example.SunwayDemo.User.entity.student.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentMapper {
    public static StudentDTO studentToStudentDto(Student student){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setName(student.getName());
        studentDTO.setBatch(student.getBatch());
        studentDTO.setRollNum(student.getRollNum());
        studentDTO.setPhoneNo(student.getPhoneNo());
        studentDTO.setFacultyId(student.getFaculty().getId());
        studentDTO.setFacultyName(student.getFaculty().getName());
        return studentDTO;
    }

    public static Student studentDtoToStudent(StudentDTO studentDTO){

        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setBatch(studentDTO.getBatch());
        student.setRollNum(studentDTO.getRollNum());
        student.setPhoneNo(studentDTO.getPhoneNo());
        student.setFaculty(new Faculty(studentDTO.getFacultyId()));
        return student;

    }

    public static List<StudentDTO> stdentToStudentDtoList(List<Student> students){
        List<StudentDTO> studentDTOS = new ArrayList<>();
        for(Student student: students){
            studentDTOS.add(studentToStudentDto(student));
        }
        return studentDTOS;
    }

    public static List<Student> studentDtoToStudentList(List<StudentDTO> studentDTOS){
        List<Student> students = new ArrayList<>();
        for (StudentDTO studentDTO: studentDTOS){
            students.add(studentDtoToStudent(studentDTO));
        }
        return students;
    }
}
