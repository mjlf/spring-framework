package com.mjlf.spring.addBeantoContext.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @ClassName DependOnA
 * @Author mjlft
 * @Date 2020/1/1 8:46
 * @Version 1.0
 * @Description TODO
 */
@DependsOn("dependOnB")
@Component
@Scope(value = "property")
public class DependOnA {

//	@Autowired
	private DependOnB dependOnB;

	public DependOnA() {
	}

	public DependOnA(DependOnB dependOnB) {
		this.dependOnB = dependOnB;
	}

	@PostConstruct
	public void init(){
		System.out.println(dependOnB);
	}
}
