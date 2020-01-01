package com.mjlf.spring.addBeantoContext.beanPostProcessor;

import com.mjlf.spring.addBeantoContext.bean.Entity;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @ClassName MyInstantiationAwareBeanPostProcessor
 * @Author mjlft
 * @Date 2019/12/30 15:21
 * @Version 1.0
 * @Description TODO
 */
@Component
public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

	@Override
	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
		return null;
	}
}
