package com.graduation.data.repository;

import com.graduation.data.entity.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface LecturerRepository extends JpaRepository<Lecturer, Long> {
    List<Lecturer> findAllByFirstName(String firstName);

    List<Lecturer> findAllByLastName(String name);

    List<Lecturer> findAllByFirstNameAndLastName(String firstName, String lastName);
}
