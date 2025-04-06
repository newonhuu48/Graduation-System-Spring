package com.graduation.data.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Pattern(regexp = "[A-Z].*", message = "Name should start with capital letter")
    @Column(name = "first_name")
    private String firstName;

    @Pattern(regexp = "[A-Z].*", message = "Name should start with capital letter")
    @Column(name = "last_name")
    private String lastName;



    //Student - Thesis request
    //Uncomment when ready


    @JsonBackReference
    @OneToOne(mappedBy = "student", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("student")
    private Request request;


}
