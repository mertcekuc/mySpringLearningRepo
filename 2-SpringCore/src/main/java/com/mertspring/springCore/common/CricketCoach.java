package com.mertspring.springCore.common;


import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{

    public CricketCoach(){
        System.out.println(getClass().getSimpleName() + " created");
    }

    @Override
    public String getDailyWorkout() {
        return "Cricket Coach says: Practice fast bowling for 15 minutes!!!";
    }
}
