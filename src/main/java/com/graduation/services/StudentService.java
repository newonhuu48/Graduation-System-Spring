package com.graduation.services;

import com.graduation.data.entity.Student;
import com.graduation.data.repository.StudentRepository;
import com.graduation.dto.StudentDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;




    public List<StudentDTO> getStudents() {
        return studentRepository.findAll().stream()
                .map(this::convertToStudentDTO)
                .collect(Collectors.toList());
    }

    private StudentDTO convertToStudentDTO(Student student) {
        return modelMapper.map(student, StudentDTO.class);
    }


    public StudentDTO getStudent(long id) {
        return modelMapper.map(studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id)), StudentDTO.class);
    }


    public Student create(StudentDTO StudentDTO) {
        return studentRepository.save(modelMapper.map(StudentDTO, Student.class));
    }


    public Student updateStudent(long id, StudentDTO studentDTO) {
        Student student = modelMapper.map(studentDTO , Student.class);
        student.setId(id);
        return studentRepository.save(student);
    }


    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }


    //SPECIFIC
    /*
    private SchoolDTO convertToSchoolDTO(School school) {
        return modelMapper.map(school, SchoolDTO.class);
    }
    */

    /*
    public List<SchoolDTO> getSchools() {
        return schoolRepository.findAll().stream()
                .map(this::convertToSchoolDTO)
                .collect(Collectors.toList());
    }
    */


    /*
    public Student getStudent(long id) {
        //Optional<Student> student = studentRepository.findById(id);

        return studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student id: " + id));
    }



    public Student create(Student student) {
        return studentRepository.save(student);
    }



    public Student updateStudent(long id, Student student) {
        student.setId(id);
        return studentRepository.save(student);
    }



    public void deleteStudent(long id) {

        studentRepository.deleteById(id);
    }




    public List<Student> getStudentsByFirstName(String firstName) {

        return studentRepository.findAllByFirstName(firstName);
    }



    public List<Student> getStudentsByLastName(String lastName) {

        return studentRepository.findAllByLastName(lastName);
    }

    */

    public List<Student> getStudentsByFirstNameAndLastName(String firstName, String lastName) {

        return studentRepository.findAllByFirstNameAndLastName(firstName, lastName);
    }


}
