package com.graduation.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.graduation.data.entity.Approved;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DefenseDTO {
    private long id;
    private double grade;
    private LocalDate date;

    @JsonBackReference
    private Approved approved;

}
