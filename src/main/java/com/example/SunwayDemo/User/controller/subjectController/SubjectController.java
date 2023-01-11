package com.example.SunwayDemo.User.controller.subjectController;

import com.example.SunwayDemo.Canteen.util.RestApi;
import com.example.SunwayDemo.User.dto.SubjectDTO;
import com.example.SunwayDemo.User.entity.subjects.Subjects;
import com.example.SunwayDemo.User.service.subject.SubjectService;
import com.example.SunwayDemo.abstracts.BaseController;
import com.example.SunwayDemo.golbal.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = RestApi.FacultySection.SUBJECT_URL)
public class SubjectController extends BaseController {

private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @PostMapping(path = "/create")
    public ResponseEntity<?> Create(@RequestBody SubjectDTO subjectDTO) {
        subjectDTO = subjectService.create(subjectDTO);
        return new ResponseEntity<>(new ApiResponse<>( messageSource.get("create", messageSource.get("faculty")), true,subjectDTO ), HttpStatus.CREATED);
    }

    @GetMapping(path = "/list")
    public ResponseEntity<?> getAll(){
        ApiResponse<List<Subjects>> Faculty = new ApiResponse<>( messageSource.get("get.all", messageSource.get("faculty")), true,subjectService.getAllSubject() );
        return new ResponseEntity<>(Faculty, HttpStatus.OK);}


    @GetMapping(path = "{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        return new ResponseEntity<>(new ApiResponse<>( messageSource.get("get", messageSource.get("subject")), true,subjectService.getSubjectById(id)), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}/delete")
    public ResponseEntity<?> deleteById(@PathVariable Integer id){
        subjectService.deleteSubjectById(id);
        return new ResponseEntity<>(new ApiResponse<>( "Faculty deleted successfully", true), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}/update")
    public ResponseEntity<?> updateById(@PathVariable Integer id, @RequestBody Subjects subjects){
        return new ResponseEntity<>(new ApiResponse<>( messageSource.get("updated", messageSource.get("subject")), true, subjectService.updateSubject(id, subjects)) , HttpStatus.OK);
    }
}
