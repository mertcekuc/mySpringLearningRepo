package com.mertspr.ng.Spr.ng.AOP.aspect;

import com.mertspr.ng.Spr.ng.AOP.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.aop.MethodMatcher;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

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
    public void nogs(JoinPoint joinPoint)
    {
        System.out.println("Advice of no getter setter ONE!!!11111");
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        //parameters
        Object[] args = joinPoint.getArgs();

        for (Object o : args){
            System.out.println(o);

            if(o instanceof Account){
                Account account = (Account) o;
                System.out.println("Name, Service Code");
                System.out.println(account.getName());
                System.out.println(account.getServiceCode());
            }
        }

        System.out.println("Method: "+ methodSignature);
    }

    @AfterReturning(
            pointcut = "execution(* com.mertspr.ng.Spr.ng.AOP.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningAdvice(
            JoinPoint joinPoint,
            List<Account> result)
    {
        String method = joinPoint.toShortString();
        System.out.println("\n===========METHOD================");
        System.out.println(method);
        System.out.println("\n===========RESULTS================");
        System.out.println(result);
        System.out.println("\n=======AFTER POST-PROCESS=========");
        convertResultToUpperCase(result);
        System.out.println(result);

    }

    private void convertResultToUpperCase(List<Account> result) {
        for(Account a: result){
            String name = a.getName();
            a.setName(name.toUpperCase());
        }
    }

    @AfterThrowing(
            pointcut = "execution(* com.mertspr.ng.Spr.ng.AOP.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc")
    public void afterThrowingAdvice(
            JoinPoint joinPoint,
            Throwable theExc){

        System.out.println("========AFTER THROWING ADVICE=====");
        System.out.println(theExc.getMessage());
        System.out.println(joinPoint.getSignature().toShortString());
    }

@After("execution(* com.mertspr.ng.Spr.ng.AOP.dao.AccountDAO.findAccounts(..))")
public void afterFinally(JoinPoint joinPoint){
        System.out.println("========AFTER ADVICE=====");
        System.out.println(joinPoint.getSignature().toShortString());
    }
}
