package com.gunjan.annotation.config;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoginAspect
{
    private Logger logger = Logger.getLogger(getClass().getName());
    
    @Before("execution(void com.gunjan..*.set*(*))")
    public void callSetter(JoinPoint joinPoint)
    {
        String methodName = joinPoint.getSignature().getName();
        Object[] objects = joinPoint.getArgs();
        StringBuilder stringBuilder = new StringBuilder();
        for(Object obj : objects)
        {
            stringBuilder.append(obj.toString());
        }
        System.out.println("calling..... method " + methodName + "with argument " + stringBuilder.toString());
        logger.log(Level.ALL, "Calling Setter Method");
    }
    
    @After("execution(void com.gunjan..*.set*(*))")
    public void afterSetter(JoinPoint joinPoint)
    {
        String methodName = joinPoint.getSignature().getName();
        Object[] objects = joinPoint.getArgs();
        StringBuilder stringBuilder = new StringBuilder();
        for(Object obj : objects)
        {
            stringBuilder.append(obj.toString());
        }
        System.out.println("After..... method " + methodName + "with argument " + stringBuilder.toString());
        logger.log(Level.ALL, "After Setter Method");
    }
    
    @Around("execution(String playGame())")
    public Object checkForRain(ProceedingJoinPoint proceedingJoinPoint) throws Throwable
    {
        boolean rain = Math.random() > 0.5;
        if(rain)
        {
            System.out.println("Raining " + proceedingJoinPoint.getTarget());
            return null;
        }
        else
        {
            System.out.println("Playing " + proceedingJoinPoint.getTarget());
            return proceedingJoinPoint.proceed();
        }
    }
}
