package org.sorinb.spring.training.aop;

import org.apache.catalina.core.ApplicationContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.sorinb.spring.training.endpoint.Logable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by sorinello on 4/18/17.
 */
@Component
@Aspect
public class LoggableAspect {



    @Around("execution(@org.sorinb.spring.training.endpoint.Logable * *(..)) && @annotation(logger)")
    public void  before(ProceedingJoinPoint joinPoint, Logable logger) throws Throwable{
        System.out.println("I have been called as an annotation before actual call");
        Long initialTime = System.currentTimeMillis();
        joinPoint.proceed();
        System.out.println("I have been called as an annotation after actual call");
        long totalTime = System.currentTimeMillis() - initialTime;
        System.out.println("method "  + joinPoint.getSignature().toShortString() + " with arguments: " + joinPoint.getArgs() + " with annotation value: " + logger.value() + " has run in: " + totalTime + " ms.");
    }

}
