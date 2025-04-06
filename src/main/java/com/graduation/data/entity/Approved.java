package com.graduation.data.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "approved")
public class Approved {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Pattern(regexp = "[A-Z].*]", message = "Name should start with capital letter")
    private String title;


    private LocalDate date;


    //@JsonManagedReference
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "request_id", referencedColumnName = "id")
    @JsonIgnoreProperties("approved")
    private Request request;


    //Defense
    //@JsonBackReference
    @JsonBackReference
    @OneToOne(mappedBy = "approved", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("approved")
    private Defense defense;

}
