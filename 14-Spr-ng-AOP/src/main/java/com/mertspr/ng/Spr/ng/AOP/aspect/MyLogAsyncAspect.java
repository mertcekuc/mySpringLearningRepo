package com.mertspr.ng.Spr.ng.AOP.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class MyLogAsyncAspect {

    @Before("com.mertspr.ng.Spr.ng.AOP.aspect.MertsAopExpressions.noGetterSetter()")
    public void nogs3(){
        System.out.println("Advice of no getter setter THREE!!!!333333");
    }

}
