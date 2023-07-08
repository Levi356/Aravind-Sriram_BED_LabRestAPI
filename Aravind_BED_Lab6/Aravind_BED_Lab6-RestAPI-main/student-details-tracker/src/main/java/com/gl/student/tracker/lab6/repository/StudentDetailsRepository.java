package com.gl.student.tracker.lab6.repository;

import com.gl.student.tracker.lab6.model.StudentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDetailsRepository extends JpaRepository<StudentDetails, Integer> {

}
