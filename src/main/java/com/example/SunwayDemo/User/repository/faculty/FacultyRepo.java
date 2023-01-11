package com.example.SunwayDemo.User.repository.faculty;

import com.example.SunwayDemo.User.entity.faculty.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepo extends JpaRepository<Faculty, Integer> {
}
