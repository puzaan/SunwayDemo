package com.example.SunwayDemo.User.repository.subject;

import com.example.SunwayDemo.User.entity.subjects.Subjects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepo extends JpaRepository<Subjects, Integer> {
}
