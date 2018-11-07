package com.smart4j.framework.aop;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * 环绕增强 - 实现前置增强和后置增强接口
 */
public class GreetingBeforeAndAfterAdvice implements MethodBeforeAdvice,AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("after");
    }

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("before");
    }
}
