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

        /*ApplicationContext context = new ClassPathXmlApplicationContext("/spring.xml");  //获取Spring Context
        Greeting greeting = (Greeting) context.getBean("greetingProxy");  //从Context中根据id获取Bean对象(其实也就是一个代理)
        greeting.sayHello("jack");   //调用代理方法*/
        //引入增强
        /*Apology apology = (Apology) greeting;   //将目标类增强向上转型为Apology接口(这是引入增强给我们带来的特性,也是"接口动态实现"功能)
        apology.saySorry("jack");*/

        /*切面*/
        /*ApplicationContext context = new ClassPathXmlApplicationContext("/spring.xml");  //获取Spring Context
        GreetingImpl greeting = (GreetingImpl) context.getBean("greetingProxy");  //从Context中根据id获取Bean对象(其实也就是一个代理)
        greeting.sayHello("jack");   //调用未被代理方法
        greeting.goodMorning("Jhon");
        greeting.goodNight("Sawer");*/

        /*自动扫描Bean名称*/
        ApplicationContext context = new ClassPathXmlApplicationContext("/spring.xml");  //获取Spring Context
        GreetingImpl greeting = (GreetingImpl) context.getBean("greetingImpl");  //从Context中根据id获取Bean对象(自动扫描的id为首字母小写的类名)
        greeting.sayHello("jack");
        greeting.goodMorning("Jhon");
        greeting.goodNight("Sawer");
    }
}
