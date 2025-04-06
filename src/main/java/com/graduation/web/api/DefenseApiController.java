package com.graduation.web.api;

import com.graduation.data.entity.Defense;
import com.graduation.dto.DefenseDTO;
import com.graduation.services.DefenseService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


//Web pages should be with
//@Controller

@RestController
@AllArgsConstructor
public class DefenseApiController {
    private DefenseService defenseService;


    //Create, Read , Update, Delete
    @GetMapping(value = "/api/defenses")
    public List<DefenseDTO> getDefenses() {

        return defenseService.getDefenses();
    }


    @GetMapping(value = "/api/defenses/grade1/{grade1}/grade2/{grade2}")
    public List<DefenseDTO> getDefensesByGradeBetween(
            @PathVariable double grade1, @PathVariable double grade2) {

        return defenseService.getDefensesByGradeBetween(grade1, grade2);
    }

    /*
    @RequestMapping("/api/defenses/{id}")
    public Defense getDefense(@PathVariable("id") long id) {

        return defenseService.getDefense(id);
    }


    @PostMapping(value = "/api/defenses")
    public Defense createDefense(@RequestBody Defense defense) {

        return defenseService.create(defense);
    }


    @PutMapping(value = "/api/defenses/{id}")
    public Defense updateDefense(@PathVariable("id") long id, @RequestBody Defense defense) {

        return defenseService.updateDefense(id, defense);
    }


    @DeleteMapping(value = "/api/defenses/{id}")
    public void deleteDefense(@PathVariable("id") long id) {
        defenseService.deleteDefense(id);
    }




    @RequestMapping("/api/defenses/grade/{grade}")
    public List<Defense> getDefensesByGrade(@PathVariable("grade") double grade) {

        return defenseService.findAllByGrade(grade);
    }

    @RequestMapping("/api/defenses/grade1/{grade1}/grade2/{grade2}")
    public List<Defense> getDefensesByGradeBetween(
            @PathVariable("grade1") double grade1,
            @PathVariable("grade2") double grade2) {

        return defenseService.findAllByGradeBetween(grade1, grade2);
    }


    @RequestMapping("/api/defenses/date1/{date1}/date2/{date2}")
    public List<Defense> getDefensesByDateBetween(
            @PathVariable("date1") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date1,
            @PathVariable("date2") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date2) {

                return defenseService.findAllByDateBetween(date1, date2);
    }


    @RequestMapping("/api/defenses/lecturerId/{id}")
    public Defense getDefenseByLecturerId(@PathVariable("id") long id) {
        return defenseService.findByLecturerId(id);
    }

    */
}
