package com.example.SunwayDemo.User.service.subject;

import com.example.SunwayDemo.User.dto.SubjectDTO;
import com.example.SunwayDemo.User.entity.faculty.Faculty;
import com.example.SunwayDemo.User.entity.subjects.Subjects;
import com.example.SunwayDemo.User.exception.FacultyNotFoundException;
import com.example.SunwayDemo.User.exception.SubjectNotFoundException;
import com.example.SunwayDemo.User.mapper.SubjectMapper;
import com.example.SunwayDemo.User.repository.faculty.FacultyRepo;
import com.example.SunwayDemo.User.repository.subject.SubjectRepo;
import com.example.SunwayDemo.User.resources.FacultyResources;
import com.example.SunwayDemo.User.resources.SubjectResources;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class SubjectServiceRepo implements SubjectService{
    private final SubjectRepo subjectRepo;

    private final FacultyRepo facultyRepo;
    public SubjectServiceRepo(SubjectRepo subjectRepo, FacultyRepo facultyRepo) {
        this.subjectRepo = subjectRepo;
        this.facultyRepo = facultyRepo;
    }

    @Override
    public SubjectDTO create(SubjectDTO subjectDTO) {
        Optional<Faculty> faculty = facultyRepo.findById(subjectDTO.getFacultyId());
        if(faculty.isPresent()){
            Faculty faculty1 = facultyRepo.findById(subjectDTO.getFacultyId()).get();
            List<Subjects> subjects = new ArrayList<>();
            for (Subjects subject: faculty1.getSubjectsList()){
                subjects.add(subject);
            }
            subjects.add(SubjectMapper.subjectDTOToSubject(subjectDTO));
            List<Subjects> saveSubject = subjectRepo.saveAll(subjects);
            faculty1.setSubjectsList(saveSubject);
            facultyRepo.save(faculty1);
            return subjectDTO;
        }else {
            throw new FacultyNotFoundException(subjectDTO.getFacultyId());
        }
    }

    @Override
    public List<Subjects> getAllSubject() {

        List<Subjects> subjects = subjectRepo.findAll();
        List<Subjects> subjectsList = new ArrayList<>();
        if(subjects.isEmpty()){
            throw new SubjectNotFoundException("No Subject List Found");
        }else {
            for(Subjects subjects1: subjects){
                subjectsList.add(new SubjectResources().CreateLinkWithSubject(subjects1));
            }
            return subjectsList;
        }
    }

    @Override
    public Subjects getSubjectById(Integer id) {
        Optional<Subjects> subjects = subjectRepo.findById(id);
        if(subjects.isPresent()){
            return new SubjectResources().CreateLinkWithSubject(subjects.get());
        }else {
            throw  new SubjectNotFoundException(id);
        }
    }

    @Override
    public String deleteSubjectById(Integer id) {
        Optional<Subjects> subjects = subjectRepo.findById(id);
        if(subjects.isPresent()){
            subjectRepo.deleteById(id);
            return "Successfully subject deleted";
        }else {
            throw  new SubjectNotFoundException(id);
        }
    }

    @Override
    public Subjects updateSubject(Integer id, Subjects subjects) {
        if (subjectRepo.findById(id).isPresent()){
            subjects.setId(id);
            return new SubjectResources().CreateLinkWithSubject(subjectRepo.save(subjects));
        }else {
            throw new SubjectNotFoundException(id);
        }
    }
}
