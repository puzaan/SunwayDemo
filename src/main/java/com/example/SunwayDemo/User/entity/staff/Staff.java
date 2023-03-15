package com.example.SunwayDemo.User.entity.staff;

import com.example.SunwayDemo.User.entity.roll.Roll;
import com.example.SunwayDemo.User.userEnums.StaffType;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "staff")
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @Enumerated(EnumType.STRING)
    private StaffType staffType;

    private String password;

    //use this for list all staff
        @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinTable(
            name = "STAFF_ROLL",
    joinColumns = {
            @JoinColumn(name ="STAFF_ID", referencedColumnName = "id")
    },
            inverseJoinColumns = {
            @JoinColumn(name = "ROLL_ID", referencedColumnName = "id")
            }
    )
    @JsonManagedReference
    private Set<Roll> rolls = new HashSet<>();

    public Staff(Integer id) {
        this.id = id;
    }


}
