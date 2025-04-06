package com.graduation.web.api;

import com.graduation.data.entity.Lecturer;
import com.graduation.dto.LecturerDTO;
import com.graduation.services.LecturerService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//Web pages should be with
//@Controller

@RestController
@AllArgsConstructor
public class LecturerApiController {


    private LecturerService lecturerService;



    @GetMapping(value = "/api/lecturers")
    public List<LecturerDTO> getLecturers() {

        return lecturerService.getLecturers();
    }

    /*
    @RequestMapping("/api/lecturers/{id}")
    public Lecturer getLecturer(@PathVariable("id") long id) {

        return lecturerService.getLecturer(id);
    }


    @PostMapping(value = "/api/lecturers")
    public Lecturer createLecturer(@RequestBody Lecturer lecturer) {

        return lecturerService.create(lecturer);
    }


    @PutMapping(value = "/api/lecturers/{id}")
    public Lecturer updateLecturer(@PathVariable("id") long id, @RequestBody Lecturer lecturer) {

        return lecturerService.updateLecturer(id, lecturer);
    }


    @DeleteMapping(value = "/api/lecturers/{id}")
    public void deleteLecturer(@PathVariable("id") long id) {
        lecturerService.deleteLecturer(id);
    }


    @RequestMapping(value = "/api/lecturers/firstName/{firstName}")
    public List<Lecturer> getLecturersByFirstName(@PathVariable("firstName") String firstName) {
        return lecturerService.getLecturersByFirstName(firstName);
    }


    @RequestMapping(value = "/api/lecturers/lastName/{lastName}")
    public List<Lecturer> getLecturersByLastName(@PathVariable("lastName") String lastName) {
        return lecturerService.getLecturersByLastName(lastName);
    }


    @RequestMapping(value = "/api/lecturers/firstName/{firstName}/lastName/{lastName}")
    public List<Lecturer> getLecturersByFirstNameAndLastName(
            @PathVariable("firstName") String firstName, @PathVariable String lastName) {

        return lecturerService.getLecturersByFirstNameAndLastName(firstName, lastName);
    }
    */

}
