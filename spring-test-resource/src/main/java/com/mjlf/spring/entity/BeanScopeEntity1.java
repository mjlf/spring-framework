package com.mjlf.spring.entity;

/**
 * @ClassName BeanScopeEntity
 * @Author mjlft
 * @Date 2019/8/17 16:26
 * @Version 1.0
 * @Description 用于验证@Configuration中@Bean的调用次数，具体结合BeanScopeTest一起看
 */
public class BeanScopeEntity1 {
	private BeanScopeEntity beanScopeEntity;

	public BeanScopeEntity1() {
	}

	public BeanScopeEntity1(BeanScopeEntity beanScopeEntity) {
		this.beanScopeEntity = beanScopeEntity;
	}

	public void setBeanScopeEntity(BeanScopeEntity beanScopeEntity) {
		this.beanScopeEntity = beanScopeEntity;
	}

	public BeanScopeEntity getBeanScopeEntity() {
		return beanScopeEntity;
	}
}
