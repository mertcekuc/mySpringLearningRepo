package com.luv2code.springboot.thymeleafdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class DemoLoggingAspect {
    private Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.controller.*.*(..))")
    public void forControllerPackage(){}

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.service.*.*(..))")
    public void forServicePackage(){}

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.dao.*.*(..))")
    public void forDaoPackage(){}

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    public void combinedPointcut(){}

    @Before("combinedPointcut()")
    public void before(JoinPoint joinPoint){
        String signature = joinPoint.getSignature().toShortString();
        System.out.println("Method called: "+signature);

        Object[] params = joinPoint.getArgs();
        System.out.println("Params:");
        for (Object p: params){
            System.out.println(p);
        }
    }

    @AfterReturning(pointcut = "combinedPointcut()",
                    returning = "result")
    public  void afterReturningAdvice(JoinPoint joinPoint,
                                      Object result){
        logger.info("=========AFTER REUTNING ADVICE===========");
        String signature = joinPoint.getSignature().toShortString();
        logger.info("Method called: "+signature);
        logger.info("There RESULT = "+result);

    }
}
