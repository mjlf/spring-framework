package com.mjlf.spring.processer;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @ClassName MyProcess
 * @Author mjlft
 * @Date 2019/7/14 14:53
 * @Version 1.0
 * @Description 定义一个后置处理器
 */
public class MyProcess implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("....");
	}
}
