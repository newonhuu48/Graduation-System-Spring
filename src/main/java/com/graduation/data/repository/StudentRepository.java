package com.graduation.data.repository;

import com.graduation.data.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAllByFirstName(String name);

    List<Student> findAllByLastName(String name);

    List<Student> findAllByFirstNameAndLastName(String firstName, String lastName);
}
