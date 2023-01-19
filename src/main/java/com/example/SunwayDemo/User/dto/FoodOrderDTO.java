package com.example.SunwayDemo.User.dto;

import com.example.SunwayDemo.Canteen.entity.foodEntity.Food;
import com.example.SunwayDemo.User.entity.order.Order;
import com.example.SunwayDemo.User.userEnums.OrderStatus;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FoodOrderDTO {
    private Integer id;
    private String studentName;
    private String studentRollNumber;
    private List<OrderParticular> orderParticular;

    private Float totalPrice;
    private OrderStatus orderStatus;

    private String cookedBy;

    public FoodOrderDTO(Order order){
        this.id = order.getId();
        this.studentName = order.getStudent().getName();
        this.studentRollNumber = order.getStudent().getRollNum();
        this.orderParticular = order.getOrderParticulars().stream().map(x->
                OrderParticular.builder()
                        .foodName(x.getFood().getFoodName())
                        .quantity(x.getQuantity())
                        .build()
        )
                .collect(Collectors.toList());
        this.totalPrice = order.getTotalPrice();
        this.orderStatus = order.getOrderStatus();
        this.cookedBy = order.getCookedBy() == null ? null : order.getCookedBy().getName();
    }


}
