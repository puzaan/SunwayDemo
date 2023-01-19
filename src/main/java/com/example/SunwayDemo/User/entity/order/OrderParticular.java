package com.example.SunwayDemo.User.entity.order;

import com.example.SunwayDemo.Canteen.entity.foodEntity.Food;
import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "order_particular")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderParticular {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "food_id ", foreignKey = @ForeignKey(name = "FK_ORDER_PARTICULAR_FOOD"))
    private Food food;

    @ManyToOne
    @JoinColumn(name = "order_id ", foreignKey = @ForeignKey(name = "FK_ORDER_PARTICULAR_ORDER"))
    private Order order;

    private Integer quantity;

    private Float orderParticularTotal;
}
