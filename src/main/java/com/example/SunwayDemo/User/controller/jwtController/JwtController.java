package com.example.SunwayDemo.User.controller.jwtController;

import com.example.SunwayDemo.User.entity.jwtReauest.JwtRequest;
import com.example.SunwayDemo.User.entity.jwtReauest.JwtResponse;
import com.example.SunwayDemo.User.entity.staff.Staff;
import com.example.SunwayDemo.User.service.jwtService.JwtService;
import com.example.SunwayDemo.User.service.staff.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class JwtController {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private StaffService staffService;


    @PostMapping({"/authenticate"})

    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        return jwtService.createJwtToken(jwtRequest);
        
    }

    @GetMapping({"/listStaff"})
    @PreAuthorize("hasRole('admin')")
    public List<Staff>ListStaff (){
        return staffService.getAll();
    }
}
