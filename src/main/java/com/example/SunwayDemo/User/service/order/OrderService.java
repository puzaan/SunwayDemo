package com.example.SunwayDemo.User.service.order;

import com.example.SunwayDemo.User.dto.FoodOrderDTO;
import com.example.SunwayDemo.User.dto.OrderDTO;
import com.example.SunwayDemo.User.dto.StudentDTO;
import com.example.SunwayDemo.User.entity.order.Order;

import java.util.List;

public interface OrderService {

    FoodOrderDTO create (OrderDTO orderDTO);

    List<Order> getAll();

    FoodOrderDTO cookOrder(Integer orderId, Integer staffId);

    FoodOrderDTO preparedBy(Integer orderId);

    FoodOrderDTO servedOrder(Integer orderId, Integer staffId);
}
