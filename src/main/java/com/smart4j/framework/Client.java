package com.smart4j.framework;

/**
 * 调用静态代理、动态代理、CGLib动态代理
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
        GreetingImpl greeting = CGLibDynamicProxy.getInstance().getProxy(GreetingImpl.class);
        greeting.sayHello("Jack");
    }
}
