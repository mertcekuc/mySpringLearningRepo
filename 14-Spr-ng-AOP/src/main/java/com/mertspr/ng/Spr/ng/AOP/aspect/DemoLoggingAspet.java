package com.mertspr.ng.Spr.ng.AOP.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class DemoLoggingAspet {

    //@Before("execution(public void com.mertspr.ng.Spr.ng.AOP.dao.AccountDAO.addAccount())")
    //@Before("execution(public void add*())")
    //@Before("execution(* add*())") // any return type
    //@Before("execution(* add*(..))")// zero or more params
    //@Before("execution(* add*(*,*))") //exact 2 prams
    /*@Before("customPointCut()") //all methods inb a package
    public void beforeAddAccountAdvice(){
        System.out.println(getClass() + " Before executing adding account advice!!!!!");
    }*/

    /*@After("customPointCut()")
    public void afterAddAccountAdvice(){
        System.out.println(getClass() + " After executing adding account advice!!!!!");

    }*/

    @Pointcut("execution(* add*(..))")
    public void customPointCut() {
        System.out.println(getClass() + "Before executing adding account advice!!!!!");
    }


    @Before("com.mertspr.ng.Spr.ng.AOP.aspect.MertsAopExpressions.noGetterSetter()")
    public void nogs(){
        System.out.println("Advice of no getter setter ONE!!!11111");
    }

}
