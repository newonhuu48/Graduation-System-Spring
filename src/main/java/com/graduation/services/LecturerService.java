package com.graduation.services;

import com.graduation.data.entity.Lecturer;
import com.graduation.data.repository.LecturerRepository;
import com.graduation.dto.LecturerDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LecturerService {

    private final LecturerRepository lecturerRepository;
    private final ModelMapper modelMapper;



    public List<LecturerDTO> getLecturers() {
        return lecturerRepository.findAll().stream()
                .map(this::convertToLecturerDTO)
                .collect(Collectors.toList());
    }

    private LecturerDTO convertToLecturerDTO(Lecturer lecturer) {
        return modelMapper.map(lecturer, LecturerDTO.class);
    }

    public LecturerDTO getLecturer(long id) {
        return modelMapper.map(lecturerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid lecturer Id:" + id)), LecturerDTO.class);
    }


    public Lecturer create(LecturerDTO LecturerDTO) {
        return lecturerRepository.save(modelMapper.map(LecturerDTO, Lecturer.class));
    }


    public Lecturer updateLecturer(long id, LecturerDTO lecturerDTO) {
        Lecturer lecturer = modelMapper.map(lecturerDTO , Lecturer.class);
        lecturer.setId(id);
        return lecturerRepository.save(lecturer);
    }


    public void deleteLecturer(long id) {
        lecturerRepository.deleteById(id);
    }


    public List<LecturerDTO> getLecturersByFirstName(String firstName) {

        return lecturerRepository.findAllByFirstName(firstName)
                .stream()
                .map(this::convertToLecturerDTO)
                .collect(Collectors.toList());
    }

    public List<LecturerDTO> getLecturersByLastName(String lastName) {

        return lecturerRepository.findAllByLastName(lastName)
                .stream()
                .map(this::convertToLecturerDTO)
                .collect(Collectors.toList());
    }



    public List<LecturerDTO> getLecturersByFirstNameAndLastName(String firstName, String lastName) {

        return lecturerRepository.findAllByFirstNameAndLastName(firstName, lastName)
                .stream()
                .map(this::convertToLecturerDTO)
                .collect(Collectors.toList());
    }

    //SPECIFIC
    /*
    public List<Lecturer> getLecturersByFirstName(String firstName) {

        return lecturerRepository.findAllByFirstName(firstName);
    }



    public List<Lecturer> getLecturersByLastName(String lastName) {

        return lecturerRepository.findAllByLastName(lastName);
    }



    public List<Lecturer> getLecturersByFirstNameAndLastName(String firstName, String lastName) {

        return lecturerRepository.findAllByFirstNameAndLastName(firstName, lastName);
    }
    */
}
