package com.smart4j.framework.aspectj;

import com.smart4j.framework.aop.Apology;

/**
 * 引入增强实现类
 */
public class ApologyImpl implements Apology {
    @Override
    public void saySorry(String name) {
        System.out.println("Sorry! " + name);
    }
}
