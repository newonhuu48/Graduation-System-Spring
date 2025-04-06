package com.graduation.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateDefenseDTO {
    private long id;
    private double grade;
    private LocalDate date;
}
