package com.mertspring.springmvc.controller;

import com.mertspring.springmvc.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    List<String> countries;
    @Value("${languages}")
    List<String> languages;
    @Value("${os}")
    List<String> systems;
    @GetMapping("/studentForm")
    public String showForm(Model model){
        Student student = new Student();

        model.addAttribute("student",student);
        model.addAttribute("countries",countries);
        model.addAttribute("languages",languages);
        model.addAttribute("systems",systems);
        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student student){
        System.out.println("Name:" +student.getFirstName()
                +" Last Name:" +student.getFirstName()
                +" Country:" + student.getCountry());
        return "student-confirmation";
    }


}
