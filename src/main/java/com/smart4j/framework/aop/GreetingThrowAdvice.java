package com.smart4j.framework.aop;


import org.springframework.aop.ThrowsAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @program: GreetingThrowAdvice
 * @description: ${description}
 * @author: Created by Autumn
 * @create: 2018-11-05 16:57
 */
@Component
public class GreetingThrowAdvice implements ThrowsAdvice {

    public void afterThrowing(Method method, Object[] args, Object target,Exception e){
        System.out.println("-------------Throw Exception-----------------");
        System.out.println("Target class: "+target.getClass().getName());
        System.out.println("Method Name: "+method.getName());
        System.out.println("Exception Message: "+e.getMessage());
        System.out.println("---------------------------------------------");
    }
}
