package com.example.SunwayDemo.Canteen.entity;

import com.example.SunwayDemo.Canteen.enums.FoodType;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;

import java.util.Date;

import static javax.persistence.GenerationType.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@DynamicInsert
@Table(name = "food")
public class Food {

    @Id
    @GeneratedValue(strategy = AUTO )
    @Column(name = "id")
    private Integer id;


    @Column(name = "food_name")
    private String foodName;


    @Column(name = "quantity")
    private Integer quantity;


    @Column(name = "price")
    private Integer price;


    @Enumerated(EnumType.STRING)
    @Column(name = "food_type")
    private FoodType foodType;



    @ManyToOne()
    //name can be anything but ref name should be @Colum name or id
    @JoinColumn(name = "food_category_id",
            foreignKey = @ForeignKey(name = "FK_FOOD_FOOD_CATEGORY_ID"),
            referencedColumnName = "id")
    private FoodCategory foodCategory;

    @CreationTimestamp
    @Column(name= "created_on")
    private Date createdOn;
    @UpdateTimestamp
    @Column(name = "updated_on")
    private Date updatedOn;

}
