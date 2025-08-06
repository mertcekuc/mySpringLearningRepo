package com.mertspr.ng.Spr.ng.AOP.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class MyAPIAnalytics {

    @Before("com.mertspr.ng.Spr.ng.AOP.aspect.MertsAopExpressions.noGetterSetter()")
    public void nogs2(){
        System.out.println("Advice of no getter setter TWO!!!!2222");
    }

}
