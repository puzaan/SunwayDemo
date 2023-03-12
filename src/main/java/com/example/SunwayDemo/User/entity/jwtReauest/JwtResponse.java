package com.example.SunwayDemo.User.entity.jwtReauest;

import com.example.SunwayDemo.User.entity.staff.Staff;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse {

    private Staff staff;
    private String jwtToken;
}
