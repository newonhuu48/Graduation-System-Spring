package com.graduation.web.view.controllers;

import com.graduation.dto.StudentDTO;
import com.graduation.services.StudentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;
    private final ModelMapper modelMapper;


    @GetMapping
    public String getStudents(Model model) {
        final List <StudentDTO> students = studentService.getStudents();

        model.addAttribute("students", students);
        return "students/students";
    }

    @GetMapping("/create-student")
    public String showCreateStudentForm(Model model) {
        model.addAttribute("student", new StudentDTO());

        return "/students/create-student";
    }

    @GetMapping("/edit-student/{id}")
    public String showEditStudentForm(Model model, @PathVariable Long id) {
        model.addAttribute("student", modelMapper.map(studentService.getStudent(id),
                StudentDTO.class));
        return "/students/edit-student";
    }




    @PostMapping("/create")
    public String createStudent(@Valid @ModelAttribute("student") StudentDTO student,
                                BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "/students/create-student";
        }

        studentService.create(modelMapper.map(student, StudentDTO.class));
        return "redirect:/students";
    }


    @PostMapping("/update/{id}")
    public String updateStudent(
            @PathVariable long id, @Valid @ModelAttribute("student") StudentDTO student,
                BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "students/edit-student";
        }

        studentService.updateStudent(id, modelMapper.map(student, StudentDTO.class));
        return "redirect:/students";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }



    /*
    @PostMapping("/create")
    public String createStudent(@ModelAttribute("student") StudentDTO student) {

        studentService.create(modelMapper.map(student, StudentDTO.class));
        return "redirect:/students";
    }

    @PostMapping("/update/{id}")
    public String updateStudent(@PathVariable long id, @ModelAttribute("student") StudentDTO student) {

        studentService.updateStudent(id, modelMapper.map(student, StudentDTO.class));
        return "redirect:/students";
    }




    @GetMapping("create-student")
    public String showCreateStudentForm(Model model) {

        model.addAttribute("student", new Student() );
        return "students/create-student";
    }


    @PostMapping("/create")
    public String createStudent(StudentDTO student) {


        studentService.create(student);
        return "redirect:/students";
    }


    @GetMapping("/edit-student/{id}")
    public String showEditStudentForm(Model model, @PathVariable long id) {

        model.addAttribute("student", studentService.getStudent(id));
        return "students/edit-student";
    }


    @PutMapping("/update/{id}")
    public String updateStudent(@PathVariable long id, StudentDTO student) {

        studentService.updateStudent(id, student);
        return "redirect:/students";
    }

    @GetMapping("delete/{id}")
    public String deleteStudent(@PathVariable long id) {

        studentService.deleteStudent(id);
        return "redirect:/students";
    }

    */
}
