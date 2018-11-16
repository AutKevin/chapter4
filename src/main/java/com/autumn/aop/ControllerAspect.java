package com.autumn.aop;

import com.autumn.annotation.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * 拦截所有Controller方法
 */
@Aspect(Controller.class)
public class ControllerAspect extends AspectProxy{
    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerAspect.class);

    private long begin;

    /**
     * 前置增强
     * @param cls    目标类
     * @param method 目标方法
     * @param params 目标方法参数
     */
    @Override
    public void before(Class<?> cls, Method method, Object[] params) throws Throwable {
        LOGGER.debug("---------begin---------");
        LOGGER.debug(String.format("Class: %s",cls.));
    }

    /**
     * 后置增强
     * @param cls    目标类
     * @param method 目标方法
     * @param result 目标方法返回结果
     */
    @Override
    public void after(Class<?> cls, Method method, Object result) throws Throwable {
        super.after(cls, method, result);
    }
}
