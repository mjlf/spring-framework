package com.mjlf.spring.addBeantoContext.annotation;

import org.springframework.beans.factory.annotation.Autowired;

import java.lang.annotation.*;

/**
 * @ClassName CustomQualifiter
 * @Author mjlft
 * @Date 2019/12/26 14:24
 * @Version 1.0
 * @Description TODO
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface CustomQualifiter {
	String value() default "";
}
