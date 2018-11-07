package com.smart4j.framework.aop;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;
import org.springframework.stereotype.Component;

/**
 * @program: GreetingIntroAdvice
 * @description: ${description}
 * @author: Created by Autumn
 * @create: 2018-11-06 09:42
 */
@Component
public class GreetingIntroAdvice extends DelegatingIntroductionInterceptor implements Apology{

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        return super.invoke(mi);
    }

    @Override
    public void saySorry(String name) {
        System.out.println("Sorry "+name);
        return ;
    }
}
