package com.smart4j.framework.aop;

import org.springframework.aop.MethodBeforeAdvice;
import java.lang.reflect.Method;

/**
 * @program: GreetingBeforeAdvice
 * @description: ${description}
 * @author: Created by Autumn
 * @create: 2018-10-31 15:01
 */

public class GreetingBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("Before");
    }
}
