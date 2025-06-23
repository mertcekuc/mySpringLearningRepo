package com.mertspring.springCore.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mertspring.springCore.common.Coach;

@RestController
public class DemoController {
    //Dependency injection
    private Coach myCoach;
    private Coach anotherCoach;


    @Autowired
    public DemoController(@Qualifier("aquatic") Coach coach){
        myCoach=coach;
    }

/* For singletone scope test
    @Autowired
    public DemoController(@Qualifier("baseballCoach") Coach coach,
                          @Qualifier("baseballCoach") Coach coach2){

        System.out.println(getClass().getSimpleName() + " created");
        this.myCoach = coach;
        this.anotherCoach = coach2;

    }*/

    //public DemoController(Coach coach){ myCoach = coach;}

    /* Setter inhection
    @Autowired
    public void setCoach(Coach theCoatch){
        myCoach = theCoatch;
    }*/

    @GetMapping("/dailyworkout")
    String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    String checkCoaches(){
        return ("Are they same ? : " + (myCoach == anotherCoach));
    }
}
