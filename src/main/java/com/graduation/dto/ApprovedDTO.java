package com.graduation.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.graduation.data.entity.Defense;
import com.graduation.data.entity.Request;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ApprovedDTO {
    private long id;
    private String title;
    private LocalDate date;

    @JsonBackReference
    private Request request;
    @JsonBackReference
    private Defense defense;

}
