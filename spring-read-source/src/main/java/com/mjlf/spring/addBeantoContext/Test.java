package com.mjlf.spring.addBeantoContext;

import com.mjlf.spring.addBeantoContext.bean.Entity;
import com.mjlf.spring.addBeantoContext.bean.OverriedPropery;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * @ClassName SpTest
 * @Author mjlft
 * @Date 2019/12/20 18:50
 * @Version 1.0
 * @Description 测试将一个对象放到 spring 容器中
 */
public class Test {
	public static void main(String[] args) throws InterruptedException {


		AnnotationConfigApplicationContext annotationConfigApplicationContext =
				new AnnotationConfigApplicationContext(Config.class);
//		ClassPathXmlApplicationContext annotationConfigApplicationContext =
//				new ClassPathXmlApplicationContext("classpath:application.xml");


		//通过这种方式注入的bean, 无法进行属性依赖
//		annotationConfigApplicationContext.getBeanFactory().registerSingleton("bean", new Entity());

//		annotationConfigApplicationContext.refresh();

		Entity entity = annotationConfigApplicationContext.getBean(Entity.class);
		entity.test();

		OverriedPropery overriedPropery = (OverriedPropery)annotationConfigApplicationContext.getBean("over");
		overriedPropery.test();
	}
}
