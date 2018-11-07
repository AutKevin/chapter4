package com.smart4j.framework;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @program: CGLibDynamicProxy
 * @description: CGLib动态代理 - 单例模式
 * @author: Created by Autumn
 * @create: 2018-10-31 10:01
 */

public class CGLibDynamicProxy implements MethodInterceptor{

    //单例模式
    private static CGLibDynamicProxy instance = new CGLibDynamicProxy();
    //私有化构造函数,防止new
    private CGLibDynamicProxy(){}
    //提供给外界获取单一实例的方法
    public static CGLibDynamicProxy getInstance(){
        return instance;
    }

    @SuppressWarnings("unchecked")
    public <T> T getProxy(Class<T> cls){
        return (T) Enhancer.create(cls,this);
    }

    @Override
    public Object intercept(Object target, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        before();
        Object result = methodProxy.invokeSuper(target,args);
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
