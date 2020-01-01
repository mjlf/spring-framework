package com.mjlf.spring.addBeantoContext.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @ClassName AfterBean
 * @Author mjlft
 * @Date 2019/12/24 13:36
 * @Version 1.0
 * @Description TODO
 */
@Component
@Order(2)
public class AfterBean implements InitializingBean {
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("AfterBean 实例化后调用， 通过实现InitializingBean");
	}
}
