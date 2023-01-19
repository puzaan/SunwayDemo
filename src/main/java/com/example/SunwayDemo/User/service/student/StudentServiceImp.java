package com.example.SunwayDemo.User.service.student;

import com.example.SunwayDemo.Canteen.repository.FoodRepository;
import com.example.SunwayDemo.User.dto.StudentDTO;
import com.example.SunwayDemo.User.entity.faculty.Faculty;
import com.example.SunwayDemo.User.entity.student.Student;
import com.example.SunwayDemo.User.exception.StudentNotFoundException;
import com.example.SunwayDemo.User.exception.SubjectNotFoundException;
import com.example.SunwayDemo.User.mapper.StudentMapper;
import com.example.SunwayDemo.User.repository.student.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImp implements StudentService {
    private final StudentRepo studentRepo;
    private final FoodRepository foodRepository;

    public StudentServiceImp(StudentRepo studentRepo,
                             FoodRepository foodRepository) {
        this.studentRepo = studentRepo;
        this.foodRepository = foodRepository;
    }

    @Override
    public StudentDTO create(StudentDTO studentDTO ) {
        Student student = Student.builder()
                .name(studentDTO.getName())
                .rollNum(studentDTO.getRollNum())
                .faculty(new Faculty(studentDTO.getFacultyId()))
                .phoneNo(studentDTO.getPhoneNo())
                .batch(studentDTO.getBatch())
                .build();
        student = studentRepo.save(student);
        studentDTO.setId(student.getId());
        return studentDTO;
    }

    @Override
    public List<StudentDTO> getAll() {
        List<Student> students = studentRepo.findAll();
        if(students.isEmpty()){
            throw new SubjectNotFoundException("No Student found");

        }else {
            return StudentMapper.stdentToStudentDtoList(students);
        }
    }

    @Override
    public StudentDTO getById(Integer id) {
        Optional<Student> student = studentRepo.findById(id);
        if(student.isPresent()){
            return StudentMapper.studentToStudentDto(student.get());
        }else {
            throw new StudentNotFoundException(id);
        }
    }

    @Override
    public String deleteById(Integer id) {

        if(studentRepo.findById(id).isPresent()){
            studentRepo.deleteById(id);
            return "successfully deleted student";
        }else {
            throw new StudentNotFoundException(id);
        }
    }

    @Override
    public Student getStudentById(Integer id) {
        Optional<Student> student = studentRepo.findById(id);
        if(student.isPresent()){
            return student.get();
        }else {
            throw new StudentNotFoundException(id);
        }
    }

    @Override
    public StudentDTO updateById(Integer id, StudentDTO studentDTO) {
        return null;
    }
}
