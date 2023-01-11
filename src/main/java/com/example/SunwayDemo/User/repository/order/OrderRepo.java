package com.example.SunwayDemo.User.repository.order;

import com.example.SunwayDemo.User.entity.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Integer> {

}
