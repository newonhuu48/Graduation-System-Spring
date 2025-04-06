package com.graduation.data.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
//import jakarta.validation.constraints.*;
import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "defense")
public class Defense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    //Validate this
    @Range(min = 2, max = 6, message = "Grade range: 2-6")
    private double grade;


    @PastOrPresent(message = "Date shouldn't be in the future.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;


    //@JsonManagedReference
    @JsonBackReference
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "approved_id", referencedColumnName = "id")
    @JsonIgnoreProperties("defense")
    private Approved approved;

}
