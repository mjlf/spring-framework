package com.mjlf.spring;

import com.mjlf.spring.config.BeanScopeTest;
import com.mjlf.spring.config.BeanScopeTest1;
import com.mjlf.spring.config.Config;
import com.mjlf.spring.entity.*;
import com.mjlf.spring.process.UserDaoApplicationAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName Test
 * @Author mjlft
 * @Date 2019/7/5 0:30
 * @Version 1.0
 * @Description TODO
 */
public class TestBeanScope {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(BeanScopeTest1.class);
		BeanScopeEntity beanScopeEntity = applicationContext.getBean(BeanScopeEntity.class);
		BeanScopeEntity1 beanScopeEntity1 = applicationContext.getBean(BeanScopeEntity1.class);
		BeanScopeEntity2 beanScopeEntity2 = applicationContext.getBean(BeanScopeEntity2.class);

		System.out.println(beanScopeEntity);
		System.out.println(beanScopeEntity1.getBeanScopeEntity());
		System.out.println(beanScopeEntity2.getBeanScopeEntity());
	}
}
