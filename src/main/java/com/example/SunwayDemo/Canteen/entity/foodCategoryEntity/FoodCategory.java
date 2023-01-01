package com.example.SunwayDemo.Canteen.entity.foodCategoryEntity;

import com.example.SunwayDemo.Canteen.entity.foodEntity.Food;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.hateoas.Links;
import org.springframework.hateoas.RepresentationModel;

import static javax.persistence.GenerationType.*;
import javax.persistence.*;
import java.io.Serializable;


@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@DynamicInsert
@Table(name = "food_category", uniqueConstraints = {@UniqueConstraint(name = "UNIQUE_Food_CAT_NAME", columnNames = {"food_category_name", "short_name"})})
public class FoodCategory{

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "food_category_name")
    private String foodCategoryName;

    @Column(name = "short_name")
    private String shortName;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(columnDefinition = "TEXT",name="description")
    private String description;


//    @JsonIgnore
//    @OneToMany(mappedBy = "foodCategory")
//    private Set<Food> foods = new HashSet<>();

    public FoodCategory(Integer id) {
        this.id = id;
    }


}
