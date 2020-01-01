package com.mjlf.spring.addBeantoContext.beanfactorypostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyOverrideConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

/**
 * @ClassName MyPropertyOverriedConfigure
 * @Author mjlft
 * @Date 2019/12/26 19:06
 * @Version 1.0
 * @Description TODO
 */
@Component
public class MyPropertyOverriedConfigure extends PropertyOverrideConfigurer {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		super.setLocation(new ClassPathResource("propertyOverried.properties", MyPropertyOverriedConfigure.class.getClassLoader()));
		super.postProcessBeanFactory(beanFactory);
	}
}
