package com.mjlf.spring.entity;

/**
 * @ClassName BeanScopeEntity
 * @Author mjlft
 * @Date 2019/8/17 16:26
 * @Version 1.0
 * @Description 用于验证@Configuration中@Bean的调用次数，具体结合BeanScopeTest一起看
 */
public class BeanScopeEntity2 {
	private BeanScopeEntity beanScopeEntity;

	public BeanScopeEntity2(BeanScopeEntity beanScopeEntity) {
		this.beanScopeEntity = beanScopeEntity;
	}

	public BeanScopeEntity2() {
	}

	public void setBeanScopeEntity(BeanScopeEntity beanScopeEntity) {
		this.beanScopeEntity = beanScopeEntity;
	}

	public BeanScopeEntity getBeanScopeEntity() {
		return beanScopeEntity;
	}
}
