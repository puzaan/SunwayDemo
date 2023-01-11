package com.example.SunwayDemo.User.controller.studentController;

import com.example.SunwayDemo.Canteen.util.RestApi;
import com.example.SunwayDemo.User.dto.StudentDTO;
import com.example.SunwayDemo.User.entity.subjects.Subjects;
import com.example.SunwayDemo.User.service.student.StudentService;
import com.example.SunwayDemo.abstracts.BaseController;
import com.example.SunwayDemo.golbal.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = RestApi.UserSection.STUDENT_URL)
public class StudentController extends BaseController {
   private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @PostMapping(path = "/create")
    public ResponseEntity<?> CreateStudent(@Valid @RequestBody StudentDTO studentDTO) {
        studentDTO = studentService.create(studentDTO);
        return new ResponseEntity<>(new ApiResponse<>( messageSource.get("create", messageSource.get("student")), true,studentDTO ), HttpStatus.CREATED);
    }

    @GetMapping(path = "/list")
    public ResponseEntity<?> getAll(){
        ApiResponse<List<StudentDTO>> studentDto = new ApiResponse<>( messageSource.get("get.all", messageSource.get("faculty")), true,studentService.getAll() );
        return new ResponseEntity<>(studentDto, HttpStatus.OK);}


    @GetMapping(path = "{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        return new ResponseEntity<>(new ApiResponse<>( messageSource.get("get", messageSource.get("subject")), true,studentService.getById(id)), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}/delete")
    public ResponseEntity<?> deleteById(@PathVariable Integer id){
        studentService.deleteById(id);
        return new ResponseEntity<>(new ApiResponse<>( "Faculty deleted successfully", true), HttpStatus.OK);
    }

//    @PutMapping(path = "/{id}/update")
//    public ResponseEntity<?> updateById(@PathVariable Integer id, @RequestBody Subjects subjects){
//        return new ResponseEntity<>(new ApiResponse<>( messageSource.get("updated", messageSource.get("subject")), true, subjectService.updateSubject(id, subjects)) , HttpStatus.OK);
//    }
}
