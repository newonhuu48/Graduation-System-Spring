package com.graduation.web.api;

import com.graduation.data.entity.Student;
import com.graduation.dto.StudentDTO;
import com.graduation.services.StudentService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//Web pages should be with
//@Controller

@RestController
@AllArgsConstructor
public class StudentApiController {


    private final ModelMapper modelMapper;
    private StudentService studentService;



    @GetMapping(value = "/api/students")
    public List<StudentDTO> getStudents() {

        return studentService.getStudents();
    }

    /*
    @RequestMapping("/api/students/{id}")
    public StudentDTO getStudent(@PathVariable("id") long id) {

        return studentService.getStudent(id);
    }

    /*
    @PostMapping(value = "/api/students")
    public StudentDTO createStudent(@RequestBody StudentDTO student) {

        return studentService.create(student);
    }



    @PutMapping(value = "/api/students/{id}")
    public Student updateStudent(@PathVariable("id") long id, @RequestBody StudentDTO student) {

        return studentService.updateStudent(id, student);
    }


    @DeleteMapping(value = "/api/students/{id}")
    public void deleteStudent(@PathVariable("id") long id) {
        studentService.deleteStudent(id);
    }



    @RequestMapping(value = "/api/students/firstName/{firstName}")
    public List<Student> getStudentsByFirstName(@PathVariable("firstName") String firstName) {
        return studentService.getStudentsByFirstName(firstName);
    }


    @RequestMapping(value = "/api/students/lastName/{lastName}")
    public List<Student> getStudentsByLastName(@PathVariable("lastName") String lastName) {
        return studentService.getStudentsByLastName(lastName);
    }


    @RequestMapping(value = "/api/students/firstName/{firstName}/lastName/{lastName}")
    public List<Student> getStudentsByFirstNameAndLastName(
            @PathVariable("firstName") String firstName, @PathVariable String lastName) {

        return studentService.getStudentsByFirstNameAndLastName(firstName, lastName);
    }

    */

}
