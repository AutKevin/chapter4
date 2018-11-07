package com.smart4j.framework.aop;

import org.springframework.aop.MethodBeforeAdvice;
import java.lang.reflect.Method;

/**
 * 前置增强
 */
public class GreetingBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("Before");
    }
}
