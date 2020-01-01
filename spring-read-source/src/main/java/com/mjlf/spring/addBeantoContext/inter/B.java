package com.mjlf.spring.addBeantoContext.inter;

import com.mjlf.spring.addBeantoContext.annotation.AannotTwo;
import com.mjlf.spring.addBeantoContext.annotation.CustomQualifiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @ClassName B
 * @Author mjlft
 * @Date 2019/12/26 14:20
 * @Version 1.0
 * @Description TODO
 */
@Component
@Scope("threadScope")
public class B {

	@Autowired
//	@CustomQualifiter("AOne")
	@Qualifier("AOne")
	private A a;

	public void testQuailifter() {
		System.out.println("xxxxx" + a);
	}
}
