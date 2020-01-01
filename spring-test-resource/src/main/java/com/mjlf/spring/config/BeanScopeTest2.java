package com.mjlf.spring.config;

import com.mjlf.spring.entity.BeanScopeEntity;
import com.mjlf.spring.entity.BeanScopeEntity1;
import com.mjlf.spring.entity.BeanScopeEntity2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @ClassName BeanScopeTest
 * @Author mjlft
 * @Date 2019/8/17 16:26
 * @Version 1.0
 * @Description 测试@Configuration间注入
 */
@Configuration
public class BeanScopeTest2 {

	@Bean
	@Scope("prototype")
	public BeanScopeEntity beanScopeEntity(){
		return new BeanScopeEntity();
	}
}
