package com.gl.student.tracker.lab6.services;

import com.gl.student.tracker.lab6.dto.StudentInformation;

import java.util.List;
import java.util.Optional;


public interface StudentDetailsService {
    void saveStudentDetails(StudentInformation information);

    void deleteStudent(int studentId);

    List<StudentInformation> retrieveAllStudents();

    Optional<StudentInformation> retrieveStudentById(int studentId);
}
