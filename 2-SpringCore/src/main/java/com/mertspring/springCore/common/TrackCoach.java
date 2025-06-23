package com.mertspring.springCore.common;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach {

    public TrackCoach(){
        System.out.println(getClass().getSimpleName() + " created");
    }

    @Override
    public String getDailyWorkout() {
        return "Track Coach says: Make daily worout!!!";
    }
}
