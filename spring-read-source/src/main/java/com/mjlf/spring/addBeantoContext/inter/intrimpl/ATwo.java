package com.mjlf.spring.addBeantoContext.inter.intrimpl;

import com.mjlf.spring.addBeantoContext.annotation.AannotTwo;
import com.mjlf.spring.addBeantoContext.inter.A;
import org.springframework.stereotype.Component;

/**
 * @ClassName ATwo
 * @Author mjlft
 * @Date 2019/12/26 14:16
 * @Version 1.0
 * @Description TODO
 */
@Component
//@AannotTwo
public class ATwo implements A {
	@Override
	public void test() {
		System.out.println("B");
	}
}
