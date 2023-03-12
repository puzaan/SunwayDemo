package com.example.SunwayDemo.User.entity.roll;


import com.example.SunwayDemo.User.entity.staff.Staff;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table(name = "roll")
public class Roll {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String rollName;
    private String rollDescription;

}
