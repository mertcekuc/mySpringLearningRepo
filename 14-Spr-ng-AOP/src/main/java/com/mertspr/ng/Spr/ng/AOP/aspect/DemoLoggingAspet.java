package com.mertspr.ng.Spr.ng.AOP.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
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

    @Pointcut("execution(* com.mertspr.ng.Spr.ng.AOP.dao.*.*(..))")
    private void customPonitcutForDAO(){}

    @Before("customPonitcutForDAO() && !forGetters() && !forSetters()")
    public void custom2(){
        System.out.println("CUSTOM2");
    }

    @Pointcut("execution(* com.mertspr.ng.Spr.ng.AOP.dao.*.get*(..))")
    public void forGetters(){}

    @Pointcut("execution(* com.mertspr.ng.Spr.ng.AOP.dao.*.set*(..))")
    public void forSetters(){}
}
