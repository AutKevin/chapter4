package com.smart4j.framework.aspectj;

import com.smart4j.framework.GreetingImpl;
import com.smart4j.framework.aop.Apology;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Aspect
 */
public class Client {
    public static void main(String[] args) {

        /*前后环绕抛出增强*/
        ApplicationContext context = new ClassPathXmlApplicationContext("/spring.xml");  //获取Spring Context
        GreetingImpl greeting = (GreetingImpl) context.getBean("greetingImpl");  //从Context中根据id获取Bean对象(自动扫描的id为首字母小写的类名)
        greeting.sayHello("jack");

        /*引入增强调用*/
        Apology apology = (Apology) greeting;   //将目标类增强向上转型为Apology接口(这是引入增强给我们带来的特性,也是"接口动态实现"功能)
        apology.saySorry("jack");
    }
}
