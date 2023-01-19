package com.example.SunwayDemo.User.service.order;

import com.example.SunwayDemo.Canteen.entity.foodEntity.Food;
import com.example.SunwayDemo.Canteen.service.foodService.FoodService;
import com.example.SunwayDemo.User.dto.FoodItemsOrderDTO;
import com.example.SunwayDemo.User.dto.FoodOrderDTO;
import com.example.SunwayDemo.User.dto.OrderDTO;
import com.example.SunwayDemo.User.entity.order.Order;
import com.example.SunwayDemo.User.entity.order.OrderParticular;
import com.example.SunwayDemo.User.entity.staff.Staff;
import com.example.SunwayDemo.User.entity.student.Student;
import com.example.SunwayDemo.User.exception.OrderNotFoundException;
import com.example.SunwayDemo.User.exception.StaffNotFoundException;
import com.example.SunwayDemo.User.exception.SubjectNotFoundException;
import com.example.SunwayDemo.User.mapper.StudentMapper;
import com.example.SunwayDemo.User.repository.order.OrderParticularRepo;
import com.example.SunwayDemo.User.repository.order.OrderRepo;
import com.example.SunwayDemo.User.repository.staff.StaffRepo;
import com.example.SunwayDemo.User.service.student.StudentService;
import com.example.SunwayDemo.User.userEnums.OrderStatus;
import com.example.SunwayDemo.User.userEnums.StaffType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    private final OrderRepo orderRepo;

    private final FoodService foodService;

    private final StudentService studentService;

    private final StaffRepo staffRepo;

    private final OrderParticularRepo orderParticularRepo;

    public OrderServiceImpl(OrderRepo orderRepo , FoodService foodService, StudentService studentService, StaffRepo staffRepo, OrderParticularRepo orderParticularRepo) {
        this.orderRepo = orderRepo;
        this.foodService = foodService;
        this.studentService = studentService;
        this.staffRepo = staffRepo;
        this.orderParticularRepo = orderParticularRepo;
    }

    @Override
    public FoodOrderDTO create(OrderDTO orderDTO) {

        Order order = new Order();
        Student student = StudentMapper.studentDtoToStudent(studentService.getById(orderDTO.getStudentId()));
        student.setId(orderDTO.getStudentId());
//        order.setStudent(new Student(orderDTO.getStudentId()));
        order.setStudent(student);
        List<OrderParticular> orderParticulars = new ArrayList<>();
        order.setOrderDate(new Date());
        order.setOrderStatus(OrderStatus.NOT_SERVE);
        order = orderRepo.save(order);
        Float price = 0F;
        for(FoodItemsOrderDTO foodItemsOrderDTO : orderDTO.getFoodOrderList()){
            Food food = foodService.FoodById(foodItemsOrderDTO.getFoodId());
            price = Float.sum(price, food.getPrice()* foodItemsOrderDTO.getQuantity());

            orderParticulars.add(OrderParticular.builder()
                            .quantity(foodItemsOrderDTO.getQuantity())
                            .food(food)
                            .order(order)
                    .build());
        }
        List<OrderParticular> orderParticularList = orderParticularRepo.saveAll(orderParticulars);
        order.setOrderParticulars(orderParticularList);
        order.setTotalPrice(price);
        order = orderRepo.save(order);
        return  new FoodOrderDTO(order);
    }

    @Override
    public List<Order> getAll() {
        List<Order> orderList = orderRepo.findAll();
        if(orderList.isEmpty()){
            throw new SubjectNotFoundException("No Student found");

        }else {
            return orderList;
        }
    }

    @Override
    public FoodOrderDTO cookOrder(Integer orderId, Integer staffId) {
        Order order = orderRepo.findById(orderId).orElseThrow(()-> new OrderNotFoundException(orderId));
        if(order.getOrderStatus().equals(OrderStatus.NOT_SERVE)) {
            order.setOrderStatus(OrderStatus.COOKING);
            Staff staff = staffRepo.findById(staffId).orElseThrow(()-> new StaffNotFoundException(staffId));
            if(staff.getStaffType().equals(StaffType.COOK)){
                order.setCookedBy(new Staff(staffId));
                order = orderRepo.save(order);
            }else {
                throw new OrderNotFoundException("This id does not belong to cook ");
            }

            return  new FoodOrderDTO(order);
        }else {
            throw new OrderNotFoundException("Order is not regular process");


        }

    }

    @Override
    public FoodOrderDTO preparedBy(Integer orderId) {
        Order order = orderRepo.findById(orderId).orElseThrow(()-> new OrderNotFoundException(orderId));
        if(order.getOrderStatus().equals(OrderStatus.COOKING)) {
            order.setOrderStatus(OrderStatus.PREPARING);
            order = orderRepo.save(order);
            return new FoodOrderDTO(order);
        }else{
            throw new OrderNotFoundException("Order is not regular process");


        }

    }

    @Override
    public FoodOrderDTO servedOrder(Integer orderId, Integer staffId) {
        Order order = orderRepo.findById(orderId).orElseThrow(()-> new OrderNotFoundException(orderId));
        if(order.getOrderStatus().equals(OrderStatus.PREPARING)){
            Staff staff = staffRepo.findById(staffId).orElseThrow(()-> new StaffNotFoundException(staffId));
            if(staff.getStaffType().equals(StaffType.WAITER)){
                order.setOrderStatus(OrderStatus.SERVED);
                order.setServedBy(new Staff(staffId));
                order = orderRepo.save(order);
                return new FoodOrderDTO(order);

            }else {
                throw new OrderNotFoundException("This id does not belong to Serve");
            }

        }else {
            throw new OrderNotFoundException("Order is not regular process");
        }


    }
}
