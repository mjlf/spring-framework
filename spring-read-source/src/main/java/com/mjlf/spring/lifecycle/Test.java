package com.mjlf.spring.lifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @ClassName SpTest
 * @Author mjlft
 * @Date 2019/12/20 18:38
 * @Version 1.0
 * @Description TODO
 */
public class Test {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext annotationConfigApplicationContext =
				new AnnotationConfigApplicationContext(Config.class);

		BeanOne beanOne = annotationConfigApplicationContext.getBean(BeanOne.class);
	}
}
