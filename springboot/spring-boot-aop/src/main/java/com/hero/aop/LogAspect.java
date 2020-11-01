package com.hero.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @description: LogAspect
 * @date: 2020/11/1
 * @author: bear
 * @version: 1.0
 */
@Aspect
@Component
public class LogAspect {

    @Before("execution(* com.hero.aop.dao..*(..))")
    public void logBefore() {
        System.out.println("Before method log done");
    }

    @After("execution(* com.hero.aop.dao..*(..))")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("After method log done + class: "+joinPoint.getTarget().getClass().getName()+"");
        System.out.println("After method log done + method: "+joinPoint.getSignature()+"");
        System.out.println("After method log done + args: "+ Arrays.asList(joinPoint.getArgs())+"");
    }
}
