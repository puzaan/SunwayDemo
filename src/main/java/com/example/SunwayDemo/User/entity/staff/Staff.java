package com.example.SunwayDemo.User.entity.staff;

import com.example.SunwayDemo.User.userEnums.StaffType;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table(name = "staff")
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @Enumerated(EnumType.STRING)
    private StaffType staffType;

    public Staff(Integer id) {
        this.id = id;
    }
}
