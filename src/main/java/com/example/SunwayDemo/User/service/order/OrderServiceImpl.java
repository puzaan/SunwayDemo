package com.example.SunwayDemo.User.service.order;

import com.example.SunwayDemo.User.repository.order.OrderRepo;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{
    private final OrderRepo orderRepo;

    public OrderServiceImpl(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }
}
