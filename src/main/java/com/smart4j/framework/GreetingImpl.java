package com.smart4j.framework;

import org.springframework.stereotype.Component;

/**
 * @program: GreetingImpl
 * @description: ${description}
 * @author: Created by Autumn
 * @create: 2018-10-30 16:26
 */
@Component
public class GreetingImpl implements Greeting {
    @Override
    public void sayHello(String name) {
        before();
        System.out.println("Hello! "+name);
        after();
    }

    private void before(){
        System.out.println("Before");
    }

    private void after(){
        System.out.println("After");
    }
}
