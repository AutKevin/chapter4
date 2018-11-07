package com.smart4j.framework.aspectj;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @program: Tag
 * @description: 切点 - 有此注解的方法
 * @author: Created by Autumn
 * @create: 2018-11-07 12:57
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Tag {
}
