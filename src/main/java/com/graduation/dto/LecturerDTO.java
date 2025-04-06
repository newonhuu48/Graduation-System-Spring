package com.graduation.dto;

import com.graduation.data.entity.Lecturer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LecturerDTO {
    private long id;
    private String firstName;
    private String lastName;
    private String position;

}
