package com.smart4j.framework;

/**
 * @program: GreetingProxy
 * @description: ${description}
 * @author: Created by Autumn
 * @create: 2018-10-30 17:12
 */

public class GreetingProxy implements Greeting {
    private GreetingImpl greetingImpl;

    public GreetingProxy(GreetingImpl greetingImpl) {
        this.greetingImpl = greetingImpl;
    }

    @Override
    public void sayHello(String name) {
        before();
        greetingImpl.sayHello(name);
        after();
    }

    private void before(){
        System.out.println("Before");
    }
    private void after(){
        System.out.println("After");
    }
}
