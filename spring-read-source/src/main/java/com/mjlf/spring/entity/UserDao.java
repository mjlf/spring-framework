package com.mjlf.spring.entity;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @ClassName UserDao
 * @Author mjlft
 * @Date 2019/7/5 0:30
 * @Version 1.0
 * @Description TODO
 */
@Component
public class UserDao {

	public void showName(){
		System.out.println("My name is mjlf, and i love whf");
	}
}

