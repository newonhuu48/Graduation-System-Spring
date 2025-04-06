package com.graduation.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.graduation.data.entity.Approved;
import com.graduation.data.entity.Lecturer;
import com.graduation.data.entity.Student;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RequestDTO {
    private long id;
    private String title;

    @JsonBackReference
    private Student student;

    @JsonBackReference
    private Lecturer lecturer;

    @JsonBackReference
    private Approved approved;
}
