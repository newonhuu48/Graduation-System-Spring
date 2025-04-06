package com.graduation.web.api;

import com.graduation.data.entity.School;
import com.graduation.services.SchoolService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class SchoolApiController {

    private final SchoolService schoolService;



    @GetMapping(value = "/api/schools")
    public List<School> getSchools() {
        return schoolService.getSchools();
    }


    @RequestMapping("/api/schools/{id}")
    public School getSchool(@PathVariable("id") int id) {
        return schoolService.getSchool(id);
    }



    @PostMapping(value = "/api/schools")
    public School createSchool(@RequestBody School school) {
        return schoolService.create(school);
    }

//    @RequestMapping(method = RequestMethod.POST, value = "/api/schools")
//    public School createSchool(School school) {
//        return schoolService.create(school);
//    }

    @RequestMapping(method = RequestMethod.PUT, value = "/api/schools/{id}")
    public School updateSchool(@PathVariable("id") long id, @RequestBody School school) {
        return schoolService.updateSchool(id, school);
    }

    @DeleteMapping(value = "/api/schools/{id}")
    public void deleteSchool(@PathVariable long id) {
        schoolService.deleteSchool(id);
    }

    @RequestMapping("/api/schools/max-students/{maxStudents}")
    public List<School> getSchoolsByMaxNumberOfStudents(@PathVariable int maxStudents) {
        return schoolService.getSchoolsByMaxNumberOfStudents(maxStudents);
    }

    @RequestMapping("/api/schools/names/{name}")
    public List<School> getSchoolsByMaxNumberOfStudents(@PathVariable String name) {
        return schoolService.getSchoolsByName(name);
    }

    @RequestMapping("/api/schools/names/{name}/max-students/{maxStudents}")
    public List<School> getSchoolsByMaxNumberOfStudents(@PathVariable String name, @PathVariable int maxStudents) {
        return schoolService.getSchoolsByNameAndMaxNumberOfStudents(name, maxStudents);
    }

    @RequestMapping("/api/highschools")
    public List<School> getHighSchools() {
        return schoolService.getAllHighSchools();
    }



}
