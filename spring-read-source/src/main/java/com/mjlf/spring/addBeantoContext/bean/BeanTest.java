package com.mjlf.spring.addBeantoContext.bean;

import org.springframework.stereotype.Component;

/**
 * @ClassName BeanTest
 * @Author mjlft
 * @Date 2019/12/25 10:34
 * @Version 1.0
 * @Description TODO
 */
@Component
public class BeanTest {

	public void init(){
		System.out.println("猜想bean merge 的作用与用法");
	}
}
