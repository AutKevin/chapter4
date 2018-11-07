package com.smart4j.framework.aspectj;

import com.smart4j.framework.aop.Apology;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

/**
 * @program: GreetingAspect
 * @description: ${description}
 * @author: Created by Autumn
 * @create: 2018-11-06 16:54
 */

@Aspect    /*切面*/
@Component
public class GreetingAspect {

    @Around("@annotation(com.smart4j.framework.aspectj.Tag)")   /*切点 - 有Tag标记的Method*/
    public Object around(ProceedingJoinPoint pjp) throws Throwable {    /*增强*/
        before();
        Object result = pjp.proceed();
        after();
        return result;
    }

    /*引入增强*/
    @DeclareParents(value = "com.smart4j.framework.GreetingImpl",defaultImpl = ApologyImpl.class)
    private Apology apology;

    private void before(){
        System.out.println("Before");
    }
    private void after(){
        System.out.println("After");
    }
}
