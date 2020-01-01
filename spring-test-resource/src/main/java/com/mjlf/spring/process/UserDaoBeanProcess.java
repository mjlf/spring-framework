package com.mjlf.spring.process;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @ClassName UserDaoBeanProcess
 * @Author mjlft
 * @Date 2019/7/6 10:20
 * @Version 1.0
 * @Description BeanPostProcessor是spring对bean的一个应用拓展点，
 * 实现该接口可以对bean 进行相应的拓展
 */
@Component
public class UserDaoBeanProcess implements BeanPostProcessor {

	//bean实例化之前做点事情
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if(bean.getClass().getSimpleName().equals("UserDao")){
			System.out.println("在UserDao实例化之后干点啥");
		}
		return bean;
	}

	/**
	 * bean实例化之后做点事情
	 * @param bean the new bean instance
	 * @param beanName the name of the bean
	 * @return
	 * @throws BeansException
	 */
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return null;
	}
}
