package com.example.SunwayDemo.Canteen.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import static javax.persistence.GenerationType.*;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "food_category")
public class FoodCategory {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "food_category_name")
    private String foodCategoryName;

    @Column(name = "is_active")
    private Boolean isActive;

    @JsonIgnore
    @OneToMany(mappedBy = "foodCategory")
    private Set<Food> foods = new HashSet<>();

}
