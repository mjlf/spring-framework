package com.mjlf.spring.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @ClassName MyCondition
 * @Author mjlft
 * @Date 2019/7/14 9:07
 * @Version 1.0
 * @Description TODO
 */
public class MyCondition implements Condition {
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		metadata.getAnnotations().forEach(x ->{
			System.out.println(x.getClass().getSimpleName());
		});
		return false;
	}
}
