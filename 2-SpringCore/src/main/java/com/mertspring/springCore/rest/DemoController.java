package com.mertspring.springCore.rest;

import com.mertspring.springCore.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    //Dependency injection
    private Coach myCoach;
    @Autowired
    public DemoController(Coach coach){
        this.myCoach = coach;
    }

    @GetMapping("/dailyworkout")
    String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

}
