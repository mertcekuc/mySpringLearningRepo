package com.mertspring.springCore.common;

import org.springframework.stereotype.Component;

public class SwimCoach implements Coach {

    public SwimCoach(){
        System.out.println(getClass().getSimpleName() + " created");
    }

    @Override
    public String getDailyWorkout() {
        return "Hello from swim coach";
    }
}
