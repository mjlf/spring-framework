package com.mjlf.spring.addBeantoContext.annotation;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

/**
 * @ClassName AannotTwo
 * @Author mjlft
 * @Date 2019/12/26 14:17
 * @Version 1.0
 * @Description TODO
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Qualifier("aOne")
public @interface AannotOne {
}
