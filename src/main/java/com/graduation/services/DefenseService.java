package com.graduation.services;

import com.graduation.data.entity.Defense;
import com.graduation.data.repository.DefenseRepository;
import com.graduation.dto.DefenseDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DefenseService {

    private final DefenseRepository defenseRepository;
    private final ModelMapper modelMapper;


    public List<DefenseDTO> getDefenses() {
        return defenseRepository.findAll().stream()
                .map(this::convertToDefenseDTO)
                .collect(Collectors.toList());
    }

    private DefenseDTO convertToDefenseDTO(Defense defense) {
        return modelMapper.map(defense, DefenseDTO.class);
    }


    public DefenseDTO getDefense(long id) {
        return modelMapper.map(defenseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid defense Id:" + id)), DefenseDTO.class);
    }


    public Defense create(DefenseDTO DefenseDTO) {
        return defenseRepository.save(modelMapper.map(DefenseDTO, Defense.class));
    }


    public Defense updateDefense(long id, DefenseDTO defenseDTO) {
        Defense defense = modelMapper.map(defenseDTO , Defense.class);
        defense.setId(id);
        return defenseRepository.save(defense);
    }


    public void deleteDefense(long id) {
        defenseRepository.deleteById(id);
    }



    public List<DefenseDTO> getDefensesByGrade(double grade) {
        return defenseRepository.findAllByGrade(grade).stream()
                .map(this::convertToDefenseDTO)
                .collect(Collectors.toList());
    }


    public List<DefenseDTO> getDefensesByGradeBetween(double grade1, double grade2) {
        return defenseRepository.findAllByGradeBetween(grade1, grade2).stream()
                .map(this::convertToDefenseDTO)
                .collect(Collectors.toList());
    }


    public List<DefenseDTO> getDefensesByDateBetween(LocalDate date1, LocalDate date2) {
        return defenseRepository.findAllByDateBetween(date1, date2).stream()
                .map(this::convertToDefenseDTO)
                .collect(Collectors.toList());
    }


    //====================
    //Positive grade - 3.0
    //====================
    /*
    public List<DefenseDTO> getDefensesByPositiveGradeAndLecturerId(long id) {
        return defenseRepository
                .findAllByApproved_Request_Lecturer_IdAndGradeGreaterThanOrEquals(id, 3.0)
                .stream().map(this::convertToDefenseDTO)
                .collect(Collectors.toList());
    }
    */


    public List<DefenseDTO> getDefensesByLecturerId(long id) {
        return defenseRepository
                .findAllByApproved_Request_Lecturer_Id(id)
                .stream().map(this::convertToDefenseDTO)
                .collect(Collectors.toList());
    }
}
