package com.gl.student.tracker.lab6.controller;

import com.gl.student.tracker.lab6.dto.StudentInformation;
import com.gl.student.tracker.lab6.services.StudentDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Optional;


@Controller
@RequestMapping("/student")
public class StudentDetailsController {
    private final StudentDetailsService studentDetailsService;

    @Autowired
    public StudentDetailsController(StudentDetailsService service) {
        this.studentDetailsService = service;
    }

    @GetMapping("/create")
    public String createStudent(Model model) {
        model.addAttribute("studentInfo", new StudentInformation());
        return "create-student";
    }

    
    @PostMapping("/savestudent")
    public String saveStudentInformation(Model model, @ModelAttribute("studentInfo") StudentInformation information) {
        studentDetailsService.saveStudentDetails(information);
        model.addAttribute("studentList", studentDetailsService.retrieveAllStudents());
        return "redirect:/student/list";
    }

   
    @RequestMapping("/list")
    public String displayAllStudents(Model model) {
        model.addAttribute("studentList", studentDetailsService.retrieveAllStudents());
        return "student-list";
    }

  
    @GetMapping("/delete/{studentId}")
    public String deleteStudentById(Model model, @PathVariable("studentId") int id) {
        studentDetailsService.deleteStudent(id);
        model.addAttribute("studentList", studentDetailsService.retrieveAllStudents());
        return "redirect:/student/list";
    }

    
    @GetMapping("/update/{studentId}")
    public String editStudentDetails(Model model, @PathVariable("studentId") int studentId) {
        Optional<StudentInformation> optional = studentDetailsService.retrieveStudentById(studentId);
        if (optional.isPresent()) {
            model.addAttribute("studentInformation", optional.get());
            return "update-student";
        } else {
            return "redirect:/student/list";
        }
    }

   
    @PostMapping("/apply/update/{studentId}")
    public String applyStudentUpdate(Model model,
                                     @PathVariable("studentId") int studentId,
                                     @ModelAttribute("studentInfo") StudentInformation information) {
        information.setStudentId(studentId);
        studentDetailsService.saveStudentDetails(information);
        model.addAttribute("studentList", studentDetailsService.retrieveAllStudents());
        return "redirect:/student/list";
    }

   
    @RequestMapping(value = "/error")
    public ModelAndView accesssDenied(Principal user) {
        ModelAndView model = new ModelAndView();
        if (user != null) {
            model.addObject("errmessage", "Hi " + user.getName() + ", you do not have permission to access this page!");
        } else {
            model.addObject("errmessage", "You do not have permission to access this page!");
        }
        model.setViewName("error-student");
        return model;
    }


}
