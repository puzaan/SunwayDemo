package com.example.SunwayDemo.User.controller.staffController;


import com.example.SunwayDemo.Canteen.util.RestApi;
import com.example.SunwayDemo.User.dto.StaffDto;
import com.example.SunwayDemo.User.entity.staff.Staff;
import com.example.SunwayDemo.User.service.staff.StaffService;
import com.example.SunwayDemo.abstracts.BaseController;
import com.example.SunwayDemo.golbal.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = RestApi.StaffSection.Staff_URL)
public class StaffController extends BaseController {

    private final StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @PostMapping(path = "/create")
    public ResponseEntity<?> Create(@RequestBody StaffDto staff) {

        StaffDto staff1 = staffService.create(staff);
        return new ResponseEntity<>(new ApiResponse<>( messageSource.get("create", messageSource.get("roll")), true,staff1 ), HttpStatus.CREATED);
    }

    @GetMapping(path = "/list")
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<?> getAll(){
        ApiResponse<List<Staff>> staff = new ApiResponse<>( messageSource.get("get.all", messageSource.get("roll")), true,staffService.getAll() );
        return new ResponseEntity<>(staff, HttpStatus.OK);}
}
