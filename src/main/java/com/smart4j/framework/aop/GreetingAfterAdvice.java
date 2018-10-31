package com.smart4j.framework.aop;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @program: GreetingBeforeAdvice
 * @description: ${description}
 * @author: Created by Autumn
 * @create: 2018-10-31 15:01
 */

public class GreetingAfterAdvice implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("After");
    }
}
