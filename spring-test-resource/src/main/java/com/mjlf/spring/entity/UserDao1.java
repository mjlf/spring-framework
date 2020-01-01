package com.mjlf.spring.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @ClassName UserDao
 * @Author mjlft
 * @Date 2019/7/5 0:30
 * @Version 1.0
 * @Description TODO
 */
@Component
public class UserDao1 {

	@Value("${test.beanfactorypostprocessor}")
	private String testProperties;


	@Value("${t.beanfactorypostprocessor}")
	private String tProperties;

	public void showName(){
		System.out.println("My name is mjlf, and i love whf");
	}

	public void showTestProperties(){
		System.out.println(tProperties);
	}
}

