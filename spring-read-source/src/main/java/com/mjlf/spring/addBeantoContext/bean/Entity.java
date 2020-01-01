package com.mjlf.spring.addBeantoContext.bean;

import com.mjlf.spring.addBeantoContext.condition.MjlfCondition;
import com.mjlf.spring.addBeantoContext.inter.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.inject.Inject;
import java.util.Date;

/**
 * @ClassName Entity
 * @Author mjlft
 * @Date 2019/12/20 18:50
 * @Version 1.0
 * @Description TODO
 */
@Component
@Conditional(MjlfCondition.class)
public class Entity {

	@Value("${orgtest}")
	private String inc;

	@Value("1992/12/12")
	private Date date;

	@Autowired
	@Qualifier("AOne")
	private A addBean;

	@Resource(name = "beanTest")
	private BeanTest beanTest;

	@Inject
	private OverriedPropery propery;

	private Integer testInject;

	public void init(){
		System.out.println("entity init method");
	}

	public void test(){
		System.out.println("date : " + inc);
//		autowireCandidate.ttt();
		System.out.println("beanTest = " + beanTest);
	}

	public void setTestInject(Integer testInject) {
		this.testInject = testInject;
	}
}
