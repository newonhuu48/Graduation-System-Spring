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


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "request")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Pattern(regexp = "[A-Z].*", message = "Name should start with capital letter")
    private String title;




    //Student
    //@JsonManagedReference
    @JsonBackReference
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    @JsonIgnoreProperties("request")
    private Student student;



    //Lecturer
    //@JsonManagedReference
    @JsonBackReference
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lecturer_id", referencedColumnName = "id")
    @JsonIgnoreProperties("request")
    private Lecturer lecturer;



    //The thesis if it is approved
    //@JsonBackReference
    @JsonBackReference
    @OneToOne(mappedBy = "request", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("request")
    private Approved approved;

}
