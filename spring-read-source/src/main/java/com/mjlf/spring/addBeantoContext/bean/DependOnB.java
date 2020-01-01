package com.mjlf.spring.addBeantoContext.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @ClassName DependOnA
 * @Author mjlft
 * @Date 2020/1/1 8:46
 * @Version 1.0
 * @Description TODO
 */
@DependsOn("dependOnA")
@Component
public class DependOnB {

//	@Autowired
	private DependOnA dependOnA;

	public DependOnB() {
	}

	public DependOnB(DependOnA dependOnA) {
		this.dependOnA = dependOnA;
	}

	@PostConstruct
	public void init(){
		System.out.println(dependOnA);
	}
}
