package com.example.SunwayDemo.User.service.staff;

import com.example.SunwayDemo.User.dto.StaffDto;
import com.example.SunwayDemo.User.entity.roll.Roll;
import com.example.SunwayDemo.User.entity.staff.Staff;

import java.util.List;

public interface StaffService {
    StaffDto create (StaffDto staffDto);
    List<Staff> getAll();

}
