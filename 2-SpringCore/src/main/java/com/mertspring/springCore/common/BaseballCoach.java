package com.mertspring.springCore.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Primary
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BaseballCoach implements Coach{

    public BaseballCoach(){
        System.out.println(getClass().getSimpleName() + " created");
    }

    @Override
    public String getDailyWorkout() {
        return "Baseball coach say: Make 15 min workkout!!";
    }


    @PostConstruct
    public void startUpStuff(){
        System.out.println("HEY it s start up method");
    }

    @PreDestroy
    public void destroyStuff(){
        System.out.println("Heyy this is destroy stuff");
    }
}
