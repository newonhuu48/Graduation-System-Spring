package com.graduation.data.repository;

import com.graduation.data.entity.Defense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface DefenseRepository extends JpaRepository<Defense, Long> {

    List<Defense> findAllByGrade(double grade);


    List<Defense> findAllByGradeBetween(double grade1, double grade2);


    List<Defense> findAllByDateBetween(LocalDate date1, LocalDate date2);

    //Not Working
    //List<Defense> findAllByApproved_Request_Lecturer_IdAndGradeGreaterThanOrEquals(long id, double grade);

    List<Defense> findAllByApproved_Request_Lecturer_Id(long id);
}
