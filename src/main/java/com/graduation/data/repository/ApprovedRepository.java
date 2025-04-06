package com.graduation.data.repository;

import com.graduation.data.entity.Approved;
import com.graduation.data.entity.Request;
import com.graduation.dto.RequestDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ApprovedRepository extends JpaRepository<Approved, Long> {

    List<Approved> findAllByTitleContaining(String substr);


    List <Approved> findByRequest_Id(Long requestId);


    List <Approved> findByRequest_Lecturer_Id(Long lecturerId);


    List<Approved> findAllByDateBetween(LocalDate date1, LocalDate date2);




    //Fetch unapproved requests
    @Query("SELECT r FROM Request r WHERE r.id NOT IN (SELECT request.id FROM Approved)")
    List<Request> findNotApproved();
}
