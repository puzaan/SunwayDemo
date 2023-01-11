package com.example.SunwayDemo.User.service.faculty;

import com.example.SunwayDemo.User.entity.faculty.Faculty;
import com.example.SunwayDemo.User.entity.subjects.Subjects;
import com.example.SunwayDemo.User.exception.FacultyNotFoundException;
import com.example.SunwayDemo.User.repository.faculty.FacultyRepo;
import com.example.SunwayDemo.User.repository.subject.SubjectRepo;
import com.example.SunwayDemo.User.resources.FacultyResources;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FacultyServiceImpl implements FacultyService{

    private final FacultyRepo facultyRepo;

    private final SubjectRepo subjectRepo;

    public FacultyServiceImpl(FacultyRepo facultyRepo, SubjectRepo subjectRepo) {
        this.facultyRepo = facultyRepo;
        this.subjectRepo = subjectRepo;
    }

    @Override
    public Faculty create(Faculty faculty) {
        List<Subjects> subjectsList = subjectRepo.saveAll(faculty.getSubjectsList());
        faculty.setSubjectsList(subjectsList);
        faculty = facultyRepo.save(faculty);
        return new FacultyResources().CreateLinkWithFaculty(faculty);

    }

    @Override
    public List<Faculty> getAllFaculty() {
        List<Faculty>facultyList = facultyRepo.findAll();
        List<Faculty> facultyList1 = new ArrayList<>();
        if(facultyList.isEmpty()){
            throw new FacultyNotFoundException("No Faculty found");
        }else{
            for (Faculty faculty : facultyList)
                facultyList1.add(new FacultyResources().CreateLinkWithFaculty(faculty));
            return facultyList1;
        }

    }

    @Override
    public Faculty getFacultyById(Integer id) {
        Optional<Faculty> faculty = facultyRepo.findById(id);
        if(faculty.isPresent()){
            return new  FacultyResources().CreateLinkWithFaculty(faculty.get());
        }else {
            throw new FacultyNotFoundException(id);
        }
    }

    @Override
    public String deleteFacultyById(Integer id) {
        if(facultyRepo.findById(id).isPresent()){
            facultyRepo.deleteById(id);
            return "Food Deleted Successfully";
        }else {
            throw new FacultyNotFoundException(id);
        }
    }

    @Override
    public Faculty updateFaculty(Integer id, Faculty faculty) {

        if(facultyRepo.findById(id).isPresent()){
            Faculty faculty1 = facultyRepo.findById(id).get();
//            Faculty faculty2 = new Faculty();
//            if(faculty.getName()!=null){
//                faculty2.setName(faculty.getName());
//            }else{
//                faculty2.setName(faculty1.getName());
//            }
//            if(faculty.getShortName() != null){
//                faculty2.setShortName(faculty.getShortName());
//            }else{
//                faculty2.setShortName(faculty1.getShortName());
//            }
            faculty.setId(id);
            faculty.setSubjectsList(faculty1.getSubjectsList());
            return new FacultyResources().CreateLinkWithFaculty(facultyRepo.save(faculty));
        }else {
            throw new FacultyNotFoundException(id);
        }
    }
}
