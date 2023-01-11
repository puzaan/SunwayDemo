package com.example.SunwayDemo.User.entity.order;

import com.example.SunwayDemo.Canteen.entity.foodEntity.Food;
import com.example.SunwayDemo.User.entity.student.Student;
import com.example.SunwayDemo.User.userEnums.OrderStatus;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;

@Email
@Table(name = "food_order")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "student_id", foreignKey = @ForeignKey(name = "FK_ORDER_STUDENT"))
    private Student student;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "order_food",
            joinColumns = @JoinColumn(name = "order_id",
                    referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "food_id",
                    referencedColumnName = "id")
    )
    private List<Food> foods;

    private Integer orderNumber;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    private Date orderDate;
    private Float totalPrice;


}
