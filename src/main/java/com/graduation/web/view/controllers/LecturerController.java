package com.graduation.web.view.controllers;

import com.graduation.dto.LecturerDTO;
import com.graduation.services.LecturerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
@RequestMapping("/lecturers")
public class LecturerController {

    private final ModelMapper modelMapper;
    private final LecturerService lecturerService;



    @GetMapping
    public String getLecturers(Model model) {
        final List <LecturerDTO> lecturers = lecturerService.getLecturers();

        model.addAttribute("lecturers", lecturers);
        return "lecturers/lecturers";
    }

    @GetMapping("/create-lecturer")
    public String showCreateLecturerForm(Model model) {
        model.addAttribute("lecturer", new LecturerDTO());

        return "/lecturers/create-lecturer";
    }

    @GetMapping("/edit-lecturer/{id}")
    public String showEditLecturerForm(Model model, @PathVariable Long id) {
        model.addAttribute("lecturer", modelMapper.map(lecturerService.getLecturer(id),
                LecturerDTO.class));
        return "/lecturers/edit-lecturer";
    }


    @PostMapping("/create")
    public String createLecturer(@Valid @ModelAttribute("lecturer") LecturerDTO lecturer,
                                 BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "/lecturers/create-lecturer";
        }

        lecturerService.create(modelMapper.map(lecturer, LecturerDTO.class));
        return "redirect:/lecturers";
    }

    @PostMapping("/update/{id}")
    public String updateLecturer(@PathVariable long id, @Valid @ModelAttribute("lecturer") LecturerDTO lecturer,
                                 BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "/lecturers/edit-lecturer";
        }

        lecturerService.updateLecturer(id, modelMapper.map(lecturer, LecturerDTO.class));
        return "redirect:/lecturers";
    }

    /*
    @PostMapping("/create")
    public String createLecturer(@ModelAttribute("lecturer") LecturerDTO lecturer) {

        lecturerService.create(modelMapper.map(lecturer, LecturerDTO.class));
        return "redirect:/lecturers";
    }


    @PostMapping("/update/{id}")
    public String updateLecturer(@PathVariable long id, @ModelAttribute("lecturer") LecturerDTO lecturer) {

        lecturerService.updateLecturer(id, modelMapper.map(lecturer, LecturerDTO.class));
        return "redirect:/lecturers";
    }
     */


    @GetMapping("/delete/{id}")
    public String deleteLecturer(@PathVariable int id) {
        lecturerService.deleteLecturer(id);
        return "redirect:/lecturers";
    }
}
