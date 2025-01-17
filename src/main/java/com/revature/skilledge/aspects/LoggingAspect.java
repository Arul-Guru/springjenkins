package com.revature.skilledge.aspects;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
//pointcut
public class LoggingAspect {

    @Before("execution(* com.revature.skilledge.service.*.*(..))")
    public void logBeforeMothod(JoinPoint joinPoint){
        System.out.println("Before execution: "+joinPoint.getSignature().getName());
    }

    @After("execution(* com.revature.skilledge.service.*.*(..))")
    public void logAfterMothod(JoinPoint joinPoint){
        System.out.println("After execution: " +joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "execution(* com.revature.skilledge.service.*.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result){
        System.out.println("After return: " + joinPoint.getSignature().getName() + "Returned value :" +result);
    }

    //Unit testing



}
