package com.mjlf.spring.config;

import com.mjlf.spring.entity.BeanScopeEntity;
import com.mjlf.spring.entity.BeanScopeEntity1;
import com.mjlf.spring.entity.BeanScopeEntity2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @ClassName BeanScopeTest
 * @Author mjlft
 * @Date 2019/8/17 16:26
 * @Version 1.0
 * @Description TODO
 */
@Configuration
//@Conditional("")//提供一个实现Condition接口的实现类， 这样只有在面子条件是才能使用该配置类
public class BeanScopeTest1 {

//	不能注入@Configuration
//	@Autowired
//	private BeanScopeTest2 beanScopeEntity2;
//

	@Bean
	@Scope("prototype")
	public BeanScopeEntity beanScopeEntity(){
		return new BeanScopeEntity();
	}

	@Bean
	public BeanScopeEntity1 beanScopeEntity1(){
		BeanScopeEntity1 beanScopeEntity1 = new BeanScopeEntity1();
		beanScopeEntity1.setBeanScopeEntity(beanScopeEntity());
		return beanScopeEntity1;
	}

	@Bean
	public BeanScopeEntity2 beanScopeEntity2(){
		BeanScopeEntity2 beanScopeEntity2 = new BeanScopeEntity2();
		beanScopeEntity2.setBeanScopeEntity(beanScopeEntity());
		return beanScopeEntity2;
	}
}
