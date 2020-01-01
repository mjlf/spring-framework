package com.mjlf.spring.lifecycle;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @ClassName BeanOne
 * @Author mjlft
 * @Date 2019/12/20 18:24
 * @Version 1.0
 * @Description 生命周期回调
 * 1. @PostConstruct
 * 2. init(), xml 中配置 init-method
 * 3. 实现InitializingBean, DisposableBean
 */
@Component
public class BeanOne {

	@PostConstruct
	public void sout(){
		System.out.println("life cycle");
	}
}
