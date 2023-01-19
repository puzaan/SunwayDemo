package com.example.SunwayDemo.User.controller.orderController;

import com.example.SunwayDemo.Canteen.util.RestApi;
import com.example.SunwayDemo.User.dto.FoodOrderDTO;
import com.example.SunwayDemo.User.dto.OrderDTO;
import com.example.SunwayDemo.User.dto.StudentDTO;
import com.example.SunwayDemo.User.entity.order.Order;
import com.example.SunwayDemo.User.service.order.OrderService;
import com.example.SunwayDemo.abstracts.BaseController;
import com.example.SunwayDemo.golbal.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = RestApi.FoodSection.FOD_ORDER)
public class OrderController extends BaseController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(path = "/create")
    public ResponseEntity<?> Create( @RequestBody OrderDTO orderDTO) {
        FoodOrderDTO order = orderService.create(orderDTO);
        return new ResponseEntity<>(new ApiResponse<>( messageSource.get("create", messageSource.get("order")), true,order ), HttpStatus.CREATED);
    }

    @GetMapping(path = "/list")
    public ResponseEntity<?> getAll(){
        ApiResponse<List<Order>> order = new ApiResponse<>( messageSource.get("get.all", messageSource.get("order")), true,orderService.getAll() );
        return new ResponseEntity<>(order, HttpStatus.OK);}

    @GetMapping(path = "cook-order/order-id/{orderId}/staff-id/{staffId}")
    public ResponseEntity<?> cookOrder(@PathVariable ("orderId") Integer orderId, @PathVariable("staffId") Integer staffId) {
        FoodOrderDTO order = orderService.cookOrder (orderId,staffId);
        return new ResponseEntity<>(new ApiResponse<>( messageSource.get("get", messageSource.get("order")), true,order ), HttpStatus.CREATED);
    }
    @GetMapping(path = "prepare-order/order-id/{orderId}")
    public ResponseEntity<?> prepareOrder(@PathVariable ("orderId") Integer orderId) {
        FoodOrderDTO order = orderService.preparedBy (orderId);
        return new ResponseEntity<>(new ApiResponse<>( messageSource.get("get", messageSource.get("order")), true,order ), HttpStatus.CREATED);
    }
    @GetMapping(path = "serve-order/order-id/{orderId}/staff-id/{staffId}")
    public ResponseEntity<?> serveOrder(@PathVariable ("orderId") Integer orderId, @PathVariable("staffId") Integer staffId) {
        FoodOrderDTO order = orderService.servedOrder (orderId,staffId);
        return new ResponseEntity<>(new ApiResponse<>( messageSource.get("get", messageSource.get("order")), true,order ), HttpStatus.CREATED);
    }
}
