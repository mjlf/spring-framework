package com.mjlf.spring.addBeantoContext.beanfactorypostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.SimpleThreadScope;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MyCustomScopeConfigurer
 * @Author mjlft
 * @Date 2019/12/26 17:42
 * @Version 1.0
 * @Description TODO
 */
@Component
public class MyCustomScopeConfigurer extends CustomScopeConfigurer {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		Map<String, Object> map = new HashMap<>();
		map.put("threadScope", new SimpleThreadScope());
		super.setScopes(map);
		super.postProcessBeanFactory(beanFactory);
	}
}
