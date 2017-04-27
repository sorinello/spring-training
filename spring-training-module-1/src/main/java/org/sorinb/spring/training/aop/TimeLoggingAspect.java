package org.sorinb.spring.training.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by sorinello on 4/10/17.
 */

@Component
@Aspect
public class TimeLoggingAspect {

//    @Before("within(org.sorinb.spring.training.endpoint.*)")
//    public void getNameAdvice(){
//        System.out.println("@Before:" + new Date());
//    }
//
//    @After("within(org.sorinb.spring.training.endpoint.*)")
//    public void logAfter() {
//        System.out.println("@After:" + new Date());
//    }
//
//    @AfterReturning("within(org.sorinb.spring.training.endpoint.*)")
//    public void logAfterReturning() {
//        System.out.println("@AfterReturning:" + new Date());
//    }
//
//    @Around("within(org.sorinb.spring.training.endpoint.*)")
//    public void profile(ProceedingJoinPoint pjp) throws Throwable{
//        System.out.println("################################################# Helo AOP");
//        long start = System.currentTimeMillis();
//        System.out.println("Going to call the method.");
//        Object output = pjp.proceed();
//        System.out.println("Method execution completed.");
//        long elapsedTime = System.currentTimeMillis() - start;
//        System.out.println("Method execution time: " + elapsedTime + " milliseconds.");
//        //return output;
//    }

//    @Around("execution(* org.sorinb.spring.training.repository.*.*(..))")
//    public void profile2(ProceedingJoinPoint pjp) throws Throwable{
//        System.out.println("################################################# Helo AOP");
//        long start = System.currentTimeMillis();
//        System.out.println("Going to call the method.");
//        Object output = pjp.proceed();
//        System.out.println("Method execution completed.");
//        long elapsedTime = System.currentTimeMillis() - start;
//        System.out.println("Method execution time: " + elapsedTime + " milliseconds.");
//        //return output;
//    }
}
