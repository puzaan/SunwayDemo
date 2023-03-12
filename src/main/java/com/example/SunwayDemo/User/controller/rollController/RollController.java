package com.example.SunwayDemo.User.controller.rollController;


import com.example.SunwayDemo.Canteen.util.RestApi;
import com.example.SunwayDemo.User.dto.FoodOrderDTO;
import com.example.SunwayDemo.User.dto.OrderDTO;
import com.example.SunwayDemo.User.entity.order.Order;
import com.example.SunwayDemo.User.entity.roll.Roll;
import com.example.SunwayDemo.User.service.service.RollService;
import com.example.SunwayDemo.abstracts.BaseController;
import com.example.SunwayDemo.golbal.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = RestApi.RollSection.Roll_URL)
public class RollController extends BaseController {

   private final RollService rollService;


    public RollController(RollService rollService) {
        this.rollService = rollService;
    }

    @PostMapping(path = "/create")
    public ResponseEntity<?> Create(@RequestBody Roll roll) {
        Roll roll1 = rollService.create(roll);
        return new ResponseEntity<>(new ApiResponse<>( messageSource.get("create", messageSource.get("roll")), true,roll1 ), HttpStatus.CREATED);
    }

    @GetMapping(path = "/list")
    public ResponseEntity<?> getAll(){
        ApiResponse<List<Roll>> order = new ApiResponse<>( messageSource.get("get.all", messageSource.get("roll")), true,rollService.getAll() );
        return new ResponseEntity<>(order, HttpStatus.OK);}

}
