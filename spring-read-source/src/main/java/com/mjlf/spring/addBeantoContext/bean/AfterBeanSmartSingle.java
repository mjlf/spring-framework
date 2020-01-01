package com.mjlf.spring.addBeantoContext.bean;

import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.stereotype.Component;

/**
 * @ClassName AfterBeanSmartSingle
 * @Author mjlft
 * @Date 2019/12/24 13:37
 * @Version 1.0
 * @Description TODO
 */
@Component
public class AfterBeanSmartSingle implements SmartInitializingSingleton {
	@Override
	public void afterSingletonsInstantiated() {
		System.out.println("AfterBeanSmartSingle 实例化后调用");
	}
}
