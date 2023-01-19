package com.example.SunwayDemo.User.repository.staff;

import com.example.SunwayDemo.User.entity.staff.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface StaffRepo extends JpaRepository<Staff, Integer> {
}
