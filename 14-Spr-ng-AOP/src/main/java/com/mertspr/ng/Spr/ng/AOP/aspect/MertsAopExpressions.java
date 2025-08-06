package com.mertspr.ng.Spr.ng.AOP.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MertsAopExpressions {
    @Pointcut("execution(* com.mertspr.ng.Spr.ng.AOP.dao.*.*(..))")
    public void customPonitcutForDAO(){}

    @Pointcut("customPonitcutForDAO() && !forGetters() && !forSetters()")
    public void noGetterSetter(){}

    @Pointcut("execution(* com.mertspr.ng.Spr.ng.AOP.dao.*.get*(..))")
    public void forGetters(){}

    @Pointcut("execution(* com.mertspr.ng.Spr.ng.AOP.dao.*.set*(..))")
    public void forSetters(){}

}
