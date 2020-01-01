package com.mjlf.spring.addBeantoContext.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @ClassName OverriedPropery
 * @Author mjlft
 * @Date 2019/12/26 19:10
 * @Version 1.0
 * @Description TODO
 */
@Component("over")
public class OverriedPropery {
	@Value("${name}")
	private String name;

	@Value("${age}")
	private String age;

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public void test(){
		System.out.println("over Name : " + name);
	}
}
