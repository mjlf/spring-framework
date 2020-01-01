package com.mjlf.spring.addBeantoContext.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @ClassName AutowireCandidate
 * @Author mjlft
 * @Date 2019/12/20 23:29
 * @Version 1.0
 * @Description
 * 在xml 配置中 添加 autowire-candidate 表示使用不作为自动候选bean
 * 也就是使用@Autowire时，不会找到这个bean
 */

@Component
public class AutowireCandidate {

	public void ttt(){
		System.out.println("测试Bean自动候选配置");
	}
}
