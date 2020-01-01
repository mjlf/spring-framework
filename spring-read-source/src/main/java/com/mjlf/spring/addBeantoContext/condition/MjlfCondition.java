package com.mjlf.spring.addBeantoContext.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @ClassName MjlfCondition
 * @Author mjlft
 * @Date 2019/12/21 18:27
 * @Version 1.0
 * @Description TODO
 */
public class MjlfCondition implements Condition {
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		return true;
	}
}
