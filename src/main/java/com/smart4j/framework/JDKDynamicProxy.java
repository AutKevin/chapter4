package com.smart4j.framework;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @program: JDKDynamicProxy
 * @description: JDK动态代理
 * @author: Created by Autumn
 * @create: 2018-10-30 17:21
 */

public class JDKDynamicProxy implements InvocationHandler {
    private Object target;

    public JDKDynamicProxy(Object target) {
        this.target = target;
    }

    @SuppressWarnings("unchecked")
    public <T> T getProxy(){
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(target,args);
        after();
        return result;
    }

    private void before(){
        System.out.println("Before");
    }

    private void after(){
        System.out.println("After");
    }
}
