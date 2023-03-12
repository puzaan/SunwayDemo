package com.example.SunwayDemo.User.dto;

import com.example.SunwayDemo.User.entity.roll.Roll;
import com.example.SunwayDemo.User.userEnums.StaffType;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StaffDto {

    private Integer id;

    private String name;

    @Enumerated(EnumType.STRING)
    private StaffType staffType;

    private String password;
    private Set<RollDto> rollDtos;

}
