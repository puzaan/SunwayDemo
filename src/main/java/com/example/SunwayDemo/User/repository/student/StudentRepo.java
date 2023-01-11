package com.example.SunwayDemo.User.repository.student;

import com.example.SunwayDemo.User.entity.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Integer> {
}
