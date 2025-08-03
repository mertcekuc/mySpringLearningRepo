package com.mertspr.ng.Spr.ng.AOP.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLoggingAspet {

    //@Before("execution(public void com.mertspr.ng.Spr.ng.AOP.dao.AccountDAO.addAccount())")
    //@Before("execution(public void add*())")
    //@Before("execution(* add*())") // any return type
    //@Before("execution(* add*(..))")// zero or more params
    //@Before("execution(* add*(*,*))") //exact 2 prams
    @Before("execution(* com.mertspr.ng.Spr.ng.AOP.dao.*.*(..))") //all methods inb a package
    public void beforeAddAccountAdvice(){
        System.out.println(getClass() + "Before executing adding account advice!!!!!");
    }
}
