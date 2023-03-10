package com.example.SunwayDemo.Canteen.entity.foodCategoryEntity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;


import static javax.persistence.GenerationType.*;
import javax.persistence.*;



@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@DynamicInsert
@Table(name = "food_category",
        uniqueConstraints = {
        @UniqueConstraint(
                name = "UNIQUE_Food_CAT_NAME",
                columnNames = {
                        "food_category_name", "short_name"
                })})
public class FoodCategory{

    @Id
    @GeneratedValue(strategy = AUTO)
    //@Column(name = "id")
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
