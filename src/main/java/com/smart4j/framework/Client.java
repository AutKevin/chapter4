package com.smart4j.framework;

/**
 * @program: Client
 * @description: ${description}
 * @author: Created by Autumn
 * @create: 2018-10-30 17:17
 */

public class Client {
    public static void main(String[] args) {
        //静态代理
        /*Greeting greetingProxy = new GreetingProxy(new GreetingImpl());
        greetingProxy.sayHello("Jack");*/
        //JDK动态代理
        /*Greeting greeting = new JDKDynamicProxy(new GreetingImpl()).getProxy();
        greeting.sayHello("Jack");*/
        //CGLib动态代理
        Greeting greeting = CGLibDynamicProxy.getInstance().getProxy(GreetingImpl.class);
        greeting.sayHello("Jack");
    }
}
