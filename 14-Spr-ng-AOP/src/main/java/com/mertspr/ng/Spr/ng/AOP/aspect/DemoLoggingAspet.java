package com.mertspr.ng.Spr.ng.AOP.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLoggingAspet {

    @Before("execution(public void addAccount())")
    public void beforeAddAccountAdvice(){
        System.out.println(getClass() + "Before executing adding account advice!!!!!");
    }
}
