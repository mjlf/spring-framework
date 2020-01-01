package com.mjlf.spring.addBeantoContext.beanfactorypostprocessor;

import com.mjlf.spring.addBeantoContext.annotation.CustomQualifiter;
import jdk.nashorn.internal.ir.SetSplitState;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.CustomAutowireConfigurer;
import org.springframework.beans.factory.annotation.QualifierAnnotationAutowireCandidateResolver;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.util.Collections;

/**
 * @ClassName MyCustomAutowireConfigurer
 * @Author mjlft
 * @Date 2019/12/26 14:27
 * @Version 1.0
 * @Description TODO
 */
@Component
public class MyCustomAutowireConfigurer extends CustomAutowireConfigurer {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

		super.setOrder(Ordered.LOWEST_PRECEDENCE);
		super.setCustomQualifierTypes(Collections.singleton(CustomQualifiter.class));
		super.postProcessBeanFactory(beanFactory);
	}
}
