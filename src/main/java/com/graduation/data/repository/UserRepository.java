package com.graduation.data.repository;

import com.graduation.data.entity.Student;
import com.graduation.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface UserRepository extends JpaRepository<User, String> {

    List<User> findAll();

    User findUserByUsername(String user);
}
