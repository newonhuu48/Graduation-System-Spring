package com.graduation.data.repository;

import com.graduation.data.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Long> {

    List<Request> findAllByTitleContaining(String substr);

    Request findByStudent_Id(Long id);

    Request findByLecturer_Id(Long id);



    //@Query("Select r FROM Request r WHERE r.title = :substr")
    //List<Request> findAllByTitleContaining(@Param("substr") String substr);
}
