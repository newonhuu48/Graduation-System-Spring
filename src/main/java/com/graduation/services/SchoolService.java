package com.graduation.services;

import com.graduation.data.entity.School;
import com.graduation.data.repository.SchoolRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SchoolService {

    private final SchoolRepository schoolRepository;



    public List<School> getSchools() {
        return schoolRepository.findAll();
    }


    public School getSchool(long id) {
        //Optional<School> school = schoolRepository.findById(id);
        return schoolRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid school Id:" + id));
    }

    public School create(School school) {
        return schoolRepository.save(school);
    }


    public School updateSchool(long id, School school) {
        school.setId(id);
        return schoolRepository.save(school);
    }


    public void deleteSchool(long id) {
//        School school = schoolRepository.findById(id).orElseThrow(()
//                -> new IllegalArgumentException("Invalid school Id:" + id));
        schoolRepository.deleteById(id);
       // return
    }


    public List<School> getSchoolsByMaxNumberOfStudents(int maxNumberOfStudents) {
        return schoolRepository.findAllByMaxNumberOfStudents(maxNumberOfStudents);
    }


    public List<School> getSchoolsByName(String name) {
        return schoolRepository.findAllByName(name);
    }


    public List<School> getSchoolsByNameAndMaxNumberOfStudents(String name, int maxstudents) {
        return schoolRepository.findAllByNameAndMaxNumberOfStudents(name, maxstudents);
    }


    public List<School> getAllHighSchools() {
        return schoolRepository.findAllHighSchools();
    }
}
