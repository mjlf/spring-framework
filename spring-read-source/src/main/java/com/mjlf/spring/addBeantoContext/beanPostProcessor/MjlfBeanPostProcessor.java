package com.mjlf.spring.addBeantoContext.beanPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @ClassName MjlfBeanPostProcessor
 * @Author mjlft
 * @Date 2019/12/23 23:17
 * @Version 1.0
 * @Description
 * BeanPostProcessor 后置处理器， 每个类实例化的时候都会执行一遍
 */
@Component
public class MjlfBeanPostProcessor implements BeanPostProcessor {
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("before mjlf bean post process beanName : " + beanName);
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("after mjlf bean post process beanName : " + beanName);
		return bean;
	}
}
