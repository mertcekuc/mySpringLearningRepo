package com.mertspr.ng.Spr.ng.AOP.service;


import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TrafficFortuneServiceImpl implements TrafficFortuneService{
    @Override
    public String getFortune() {
        try {
        TimeUnit.SECONDS.sleep(5);
        }
        catch (Exception e){
            throw  new RuntimeException(e);
        }

        return "we expect open traffic this morning";

    }

    @Override
    public String getFortune(boolean wire) {
        if (wire)
            throw new RuntimeException("Exception from trig wire");
        try {
            TimeUnit.SECONDS.sleep(5);
        }
        catch (Exception e){
            throw  new RuntimeException(e);
        }

        return "we expect open traffic this morning";
    }
}
