package com.mjlf.spring.process;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @ClassName UserDaoBeanProcess
 * @Author mjlft
 * @Date 2019/7/6 10:20
 * @Version 1.0
 * @Description BeanFactoryPostProcessor对beanDefinition的一个拓展点，
 * 可以通过beanFacrory对指定的beanDefinition进行修改
 */
@Component
public class UserDaoBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
//		获取beanDefinition, 这样就可以在实例化bean之前调整beanDefinition的元数据
//		beanFactory.getBeanDefinition()
	}
}
