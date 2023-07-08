package com.gl.student.tracker.lab6;

import com.gl.student.tracker.lab6.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class StudentDetailsTrackerApplication {
    @Autowired
    private UserRepository mUserRepository;

 
    public static void main(String[] args) {
        SpringApplication.run(StudentDetailsTrackerApplication.class, args);
    }

}
