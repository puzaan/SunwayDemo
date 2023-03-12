package com.example.SunwayDemo.User.service.staff;


import com.example.SunwayDemo.User.dto.RollDto;
import com.example.SunwayDemo.User.dto.StaffDto;
import com.example.SunwayDemo.User.entity.roll.Roll;
import com.example.SunwayDemo.User.entity.staff.Staff;
import com.example.SunwayDemo.User.repository.staff.StaffRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.example.SunwayDemo.Canteen.mapper.RollMapper.rollDtoToRoll;

@Service
public class StaffServiceImp implements StaffService{

    private final StaffRepo staffRepo;


    @Autowired
    private PasswordEncoder passwordEncoder;

    public StaffServiceImp(StaffRepo staffRepo) {
        this.staffRepo = staffRepo;
    }



    public String getEncodedPassword (String password){
        return passwordEncoder.encode(password);
    }

    @Override
    public StaffDto create(StaffDto staffDto) {
        Staff staff1 = new Staff();
        staff1.setName(staffDto.getName());
        staff1.setStaffType(staffDto.getStaffType());
        staff1.setPassword(getEncodedPassword(staffDto.getPassword()));
        staff1.setRolls(rollDtoToRoll(staffDto.getRollDtos()));
        staffRepo.save(staff1);
        staffDto.setId(staff1.getId());
        System.out.println(staffDto);
        return staffDto;
    }

    @Override
    public List<Staff> getAll() {
        return staffRepo.findAll();
    }
}
