package com.mjlf.spring;

import com.mjlf.spring.config.Config;
import com.mjlf.spring.entity.UserDao;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.ResolvableType;

/**
 * @ClassName SpTest
 * @Author mjlft
 * @Date 2019/7/5 0:30
 * @Version 1.0
 * @Description TODO
 */
public class SpTest {

	public static void main(String[] args) {
		ResolvableType resolvableType = ResolvableType.forClass(SpTest.class);
		System.out.println(resolvableType.getType());
		System.out.println(resolvableType.getSource());
	}
}
