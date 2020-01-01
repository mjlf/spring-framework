package com.mjlf.spring.entity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @ClassName UserDao
 * @Author mjlft
 * @Date 2019/7/5 0:30
 * @Version 1.0
 * @Description TODO
 */
@Component
public class UserDao {


	@PostConstruct
	public void init(){
		System.out.println("init");
	}

	public void showName(){
		System.out.println("My name is mjlf, and i love whf");
	}

	@PreDestroy
	public void close(){
		System.out.println("destroy");
	}

}

