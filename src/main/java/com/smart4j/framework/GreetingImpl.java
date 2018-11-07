package com.smart4j.framework;

import com.smart4j.framework.aspectj.Tag;
import org.springframework.stereotype.Component;

/**
 * 代理目标
 */
@Component
public class GreetingImpl implements Greeting {
    @Tag   /*AspectJ 注解*/
    @Override
    public void sayHello(String name) {
        //before();    //写死情况
        System.out.println("Hello! "+name);
        //after();     //写死情况
        //throw new RuntimeException("Error");   /*异常抛出增强*/
    }

    /*切面新增方法*/
    public void goodMorning(String name){
        System.out.println("Good Morning!"+name);
    }
    public void goodNight(String name){
        System.out.println("Good Night!"+name);
    }

    /*写死*/
    /*private void before(){
        System.out.println("Before");
    }
    private void after(){
        System.out.println("After");
    }*/
}
