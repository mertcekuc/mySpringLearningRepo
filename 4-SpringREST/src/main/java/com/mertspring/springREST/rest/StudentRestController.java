package com.mertspring.springREST.rest;

import com.mertspring.springREST.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    List<Student> listOfS = new ArrayList<>();

    @PostConstruct
    void laodData(){
        listOfS.add(new Student("Mert","Cekuc"));
        listOfS.add(new Student("John","Doe"));
        listOfS.add(new Student("Abc","Def"));
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return listOfS;
    }

    @GetMapping("/students/{studentid}")
    public Student getStudent(@PathVariable int studentid){
        
        return listOfS.get(studentid);
    }
}
