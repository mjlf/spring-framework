package com.mjlf.spring.addBeantoContext.bean;

import com.mjlf.spring.addBeantoContext.bean.Entity;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @ClassName AddBean
 * @Author mjlft
 * @Date 2019/12/20 18:43
 * @Version 1.0
 * @Description TODO
 */
@Component
public class AddBean implements FactoryBean<Object>, SmartInitializingSingleton, InitializingBean {

	@Override
	public Object getObject() throws Exception {
		return  new Entity();
	}

	@Override
	public Class<?> getObjectType() {
		return null;
	}

	@PostConstruct
	public void postAddBean(){
		System.out.println("AddBean 实例化后需要执行的方法");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("AddBean 实例化后需要执行的方法afterPropertiesSet");
	}

	@Override
	public void afterSingletonsInstantiated() {
		System.out.println("AddBean 实例化后需要执行的方法afterSingletonsInstantiated");
	}
}
