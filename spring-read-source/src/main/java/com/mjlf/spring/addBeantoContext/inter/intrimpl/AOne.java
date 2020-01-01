package com.mjlf.spring.addBeantoContext.inter.intrimpl;

import com.mjlf.spring.addBeantoContext.annotation.AannotOne;
import com.mjlf.spring.addBeantoContext.annotation.AannotTwo;
import com.mjlf.spring.addBeantoContext.inter.A;
import org.springframework.stereotype.Component;

/**
 * @ClassName AOne
 * @Author mjlft
 * @Date 2019/12/26 14:16
 * @Version 1.0
 * @Description TODO
 */
@Component
//@AannotOne
public class AOne implements A {
	@Override
	public void test() {
		System.out.println("A");
	}
}
