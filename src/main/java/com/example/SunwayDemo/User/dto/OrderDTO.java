package com.example.SunwayDemo.User.dto;

import com.example.SunwayDemo.User.userEnums.OrderStatus;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;
import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDTO {

    private Integer orderId;
    private Integer studentId;
    private List<FoodItemsOrderDTO>foodOrderList;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    private Date orderDate = new Date();
}
