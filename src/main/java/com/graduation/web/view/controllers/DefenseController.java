package com.graduation.web.view.controllers;

import com.graduation.dto.DefenseDTO;
import com.graduation.dto.RequestDTO;
import com.graduation.services.DefenseService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/defenses")
public class DefenseController {

    private final DefenseService defenseService;
    private final ModelMapper modelMapper;



    @GetMapping
    public String getDefenses(Model model) {
        final List <DefenseDTO> defenses = defenseService.getDefenses();

        model.addAttribute("defenses", defenses);
        return "defenses/defenses";
    }

    @GetMapping("/create-defense")
    public String showCreateDefenseForm(Model model) {
        model.addAttribute("defense", new DefenseDTO());

        return "/defenses/create-defense";
    }

    @GetMapping("/edit-defense/{id}")
    public String showEditDefenseForm(Model model, @PathVariable Long id) {
        model.addAttribute("defense", modelMapper.map(defenseService.getDefense(id),
                DefenseDTO.class));
        return "/defenses/edit-defense";
    }


    @PostMapping("/create")
    public String createDefense(@Valid @ModelAttribute("defense") DefenseDTO defense,
                                BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "/defenses/create-defense";
        }

        defenseService.create(modelMapper.map(defense, DefenseDTO.class));
        return "redirect:/defenses";
    }

    @PostMapping("/update/{id}")
    public String updateDefense(@PathVariable long id, @Valid @ModelAttribute("defense") DefenseDTO defense,
                                BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "/defenses/edit-defense";
        }

        defenseService.updateDefense(id, modelMapper.map(defense, DefenseDTO.class));
        return "redirect:/defenses";
    }




    /*
    @PostMapping("/create")
    public String createDefense(@ModelAttribute("defense") DefenseDTO defense) {

        defenseService.create(modelMapper.map(defense, DefenseDTO.class));
        return "redirect:/defenses";
    }


    @PostMapping("/update/{id}")
    public String updateDefense(@PathVariable long id, @ModelAttribute("defense") DefenseDTO defense) {

        defenseService.updateDefense(id, modelMapper.map(defense, DefenseDTO.class));
        return "redirect:/defenses";
    }
    */


    @GetMapping("/delete/{id}")
    public String deleteDefense(@PathVariable int id) {
        defenseService.deleteDefense(id);
        return "redirect:/defenses";
    }


    //SPECIFIC
    //Find by specific grade
    @GetMapping("/grade-search/{grade}")
    public String getDefensesByGrade(Model model, @PathVariable("grade") double grade) {


        final List <DefenseDTO> defenses = defenseService.getDefensesByGrade(grade);


        model.addAttribute("defenses", defenses);
        return "defenses/defenses";
    }


    @GetMapping("/grades-search/grade1/{grade1}/grade2/{grade2}")
    public String getDefensesByGradeBetween(
            Model model, @PathVariable("grade1") double grade1, @PathVariable("grade2") double grade2) {



        final List <DefenseDTO> defenses = defenseService.getDefensesByGradeBetween(grade1, grade2);


        model.addAttribute("defenses", defenses);
        return "defenses/defenses";
    }



    @GetMapping("/dates-search/date1/{date1}/date2/{date2}")
    public String getDefensesByGradeBetween(
            Model model,
            @PathVariable("date1") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date1,
            @PathVariable("date2") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date2) {



        final List <DefenseDTO> defenses = defenseService.getDefensesByDateBetween(date1, date2);


        model.addAttribute("defenses", defenses);
        return "defenses/defenses";
    }


    /*
    @GetMapping("/positive-lecturer-search/lecturer/{id}")
    public String getDefensesByPositiveGradeAndLecturerId(Model model,
        @PathVariable("id") long id) {


            final List <DefenseDTO> defenses = defenseService.getDefensesByPositiveGradeAndLecturerId(id);


            model.addAttribute("defenses", defenses);
            return "defenses/defenses";
    }
    */


    @GetMapping("/lecturer-search/lecturer/{id}")
    public String getDefensesByLecturerId(Model model, @PathVariable("id") long id) {


        final List <DefenseDTO> defenses = defenseService.getDefensesByLecturerId(id);


        model.addAttribute("defenses", defenses);
        return "defenses/defenses";
    }
}