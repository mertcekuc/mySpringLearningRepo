package com.mertspring.springCore.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class TennisCoach implements Coach {

    public TennisCoach(){
        System.out.println(getClass().getSimpleName() + " created");
    }

    @Override
    public String getDailyWorkout() {
        return "Tennis coach says: Make 30 min daily wrkout!!!";
    }
}
