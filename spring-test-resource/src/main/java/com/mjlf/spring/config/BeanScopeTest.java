package com.mjlf.spring.config;

import com.mjlf.spring.entity.BeanScopeEntity;
import com.mjlf.spring.entity.BeanScopeEntity1;
import com.mjlf.spring.entity.BeanScopeEntity2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName BeanScopeTest
 * @Author mjlft
 * @Date 2019/8/17 16:26
 * @Version 1.0
 * @Description TODO
 */
@Configuration
public class BeanScopeTest {

	@Bean
	public BeanScopeEntity beanScopeEntity(){
		return new BeanScopeEntity();
	}

	@Bean
	public BeanScopeEntity1 beanScopeEntity1(BeanScopeEntity beanScopeEntity){
		return new BeanScopeEntity1(beanScopeEntity);
	}

	@Bean
	public BeanScopeEntity2 beanScopeEntity2(BeanScopeEntity beanScopeEntity){
		return new BeanScopeEntity2(beanScopeEntity);
	}
}
