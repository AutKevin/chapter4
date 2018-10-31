package com.smart4j.framework.aop;

import com.smart4j.framework.Greeting;
import com.smart4j.framework.GreetingImpl;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: Client
 * @description: ${description}
 * @author: Created by Autumn
 * @create: 2018-10-31 15:06
 */

public class Client {
    public static void main(String[] args) {
        /*ProxyFactory proxyFactory = new ProxyFactory();  //创建代理工厂
        proxyFactory.setTarget(new GreetingImpl());    //摄入目标类对象
        //proxyFactory.addAdvice(new GreetingBeforeAdvice());   //添加前置增强
        //proxyFactory.addAdvice(new GreetingAfterAdvice());   //添加后置增强
        //proxyFactory.addAdvice(new GreetingBeforeAndAfterAdvice());   //实现两个接口
        proxyFactory.addAdvice(new GreetingAroundAdvice());  //实现一个Around环绕式接口
        Greeting greeting = (Greeting) proxyFactory.getProxy();
        greeting.sayHello("Jack");*/
        ApplicationContext context = new ClassPathXmlApplicationContext("/spring.xml");  //获取Spring Context
        Greeting greeting = (Greeting) context.getBean("greetingProxy");  //从Context中根据id获取Bean对象(其实也就是一个代理)
        greeting.sayHello("jack");   //调用代理方法

    }
}
