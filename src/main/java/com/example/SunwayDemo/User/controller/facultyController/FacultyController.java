package com.example.SunwayDemo.User.controller.facultyController;

import com.example.SunwayDemo.Canteen.dto.foodCategoryDto.FoodCategoryDto;
import com.example.SunwayDemo.Canteen.dto.foodDto.FoodDto;
import com.example.SunwayDemo.Canteen.util.RestApi;
import com.example.SunwayDemo.User.entity.faculty.Faculty;
import com.example.SunwayDemo.User.service.faculty.FacultyService;
import com.example.SunwayDemo.abstracts.BaseController;
import com.example.SunwayDemo.golbal.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(path = RestApi.UserSection.FACULTY_URL)
public class FacultyController extends BaseController {

    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping(path = "/create")
    public ResponseEntity<?> CreateFaculty(@Valid @RequestBody Faculty faculty) {
        faculty = facultyService.create(faculty);
        return new ResponseEntity<>(new ApiResponse<>( messageSource.get("create", messageSource.get("faculty")), true,faculty ), HttpStatus.CREATED);
    }

    @GetMapping(path = "/list")
    public ResponseEntity<?> getAllFaculty(){
        ApiResponse<List<Faculty>> Faculty = new ApiResponse<>( messageSource.get("get.all", messageSource.get("faculty")), true,facultyService.getAllFaculty() );
        return new ResponseEntity<>(Faculty, HttpStatus.OK);}


    @GetMapping(path = "{id}")
    public ResponseEntity<?> getFacultyById(@PathVariable Integer id){
        return new ResponseEntity<>(new ApiResponse<>( messageSource.get("get", messageSource.get("faculty")), true,facultyService.getFacultyById(id)), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}/delete")
    public ResponseEntity<?> deleteFacultyById(@PathVariable Integer id){
        facultyService.deleteFacultyById(id);
        return new ResponseEntity<>(new ApiResponse<>( "Faculty deleted successfully", true), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}/update")
    public ResponseEntity<?> updateFaculty(@PathVariable Integer id, @RequestBody Faculty faculty){
        return new ResponseEntity<>(new ApiResponse<>( messageSource.get("updated", messageSource.get("faculty")), true, facultyService.updateFaculty(id, faculty)) , HttpStatus.OK);
    }
}
