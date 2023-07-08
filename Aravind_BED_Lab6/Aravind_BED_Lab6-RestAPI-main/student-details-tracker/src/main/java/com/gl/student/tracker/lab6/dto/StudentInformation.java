package com.gl.student.tracker.lab6.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentInformation {
    private int studentId;
    private String firstName;
    private String lastName;
    private String courseName;
    private String country;
}
