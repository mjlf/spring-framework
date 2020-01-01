package com.mjlf.spring.entity;

/**
 * @ClassName BeanScopeEntity
 * @Author mjlft
 * @Date 2019/8/17 16:26
 * @Version 1.0
 * @Description 用于验证@Configuration中@Bean的调用次数，具体结合BeanScopeTest一起看
 */
public class BeanScopeEntity {
	private static int count = 0;
	public BeanScopeEntity() {
		System.out.println("我被调用了" + (count++));
	}
}
