package com.kuang.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class MathAspect {

    @Pointcut("execution(public int com.kuang.aop.MyMath.*(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void logStart(JoinPoint joinpoint) {
        Object[] args = joinpoint.getArgs();
        System.out.println("log start " + joinpoint.getSignature().getName() + " " + Arrays.asList(args));
    }

    @After("pointCut()")
    public void logEnd(JoinPoint joinPoint) {
        System.out.println("log end " + joinPoint.getSignature().getName());
    }

    @AfterReturning(value = "pointCut()", returning = "result")
    public void logReturn(JoinPoint joinPoint, Object result) {
        System.out.println("log return " + joinPoint.getSignature().getName() + " " + result);
    }

    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void logException(JoinPoint joinPoint, Exception exception) {
        System.out.println("log Exception " + joinPoint.getSignature().getDeclaringTypeName() + " " + exception);
    }

}
