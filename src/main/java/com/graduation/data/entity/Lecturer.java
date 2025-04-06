package com.graduation.data.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lecturer")
public class Lecturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Pattern(regexp = "[A-Z].*", message = "Name should start with capital letter")
    @Column(name = "first_name")
    private String firstName;

    @Pattern(regexp = "[A-Z].*", message = "Name should start with capital letter")
    @Column(name = "last_name")
    private String lastName;


    @Column(name = "position")
    private String position;


    //Lecturer - Leading student thesis
    @JsonBackReference
    @OneToOne(mappedBy = "lecturer", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("lecturer")
    private Request request;


}
