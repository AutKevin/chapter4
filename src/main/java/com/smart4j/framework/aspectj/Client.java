package com.smart4j.framework.aspectj;

import com.smart4j.framework.GreetingImpl;
import com.smart4j.framework.aop.Apology;
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

        ApplicationContext context = new ClassPathXmlApplicationContext("/spring.xml");  //获取Spring Context
        GreetingImpl greeting = (GreetingImpl) context.getBean("greetingImpl");  //从Context中根据id获取Bean对象(自动扫描的id为首字母小写的类名)
        greeting.sayHello("jack");

        Apology apology = (Apology) greeting;   //将目标类增强向上转型为Apology接口(这是引入增强给我们带来的特性,也是"接口动态实现"功能)
        apology.saySorry("jack");
    }
}
