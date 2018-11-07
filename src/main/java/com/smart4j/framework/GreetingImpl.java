package com.smart4j.framework;

import com.smart4j.framework.aspectj.Tag;
import org.springframework.stereotype.Component;

/**
 * @program: GreetingImpl
 * @description: ${description}
 * @author: Created by Autumn
 * @create: 2018-10-30 16:26
 */
@Component
public class GreetingImpl implements Greeting {
    @Tag   /*AspectJ 注解*/
    @Override
    public void sayHello(String name) {
        //before();
        System.out.println("Hello! "+name);
        //after();
        //throw new RuntimeException("Error");
    }

    /*切面新增方法*/
    public void goodMorning(String name){
        System.out.println("Good Morning!"+name);
    }
    public void goodNight(String name){
        System.out.println("Good Night!"+name);
    }

    private void before(){
        System.out.println("Before");
    }

    private void after(){
        System.out.println("After");
    }
}
