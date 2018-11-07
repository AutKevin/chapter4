package com.smart4j.framework.aspectj;

import com.smart4j.framework.aop.Apology;

/**
 * @program: ApologyImpl
 * @description: 引入增强实现类
 * @author: Created by Autumn
 * @create: 2018-11-07 14:23
 */

public class ApologyImpl implements Apology {
    @Override
    public void saySorry(String name) {
        System.out.println("Sorry! " + name);
    }
}
