package com.mertspring.springREST.rest;

import com.mertspring.springREST.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
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

        if (studentid >= listOfS.size() || studentid<0){
            throw new StudentNotFoundException("Student id not found: "+studentid);
        }

        return listOfS.get(studentid);

    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException e){

        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(e.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleAll(Exception e){
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(e.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}
