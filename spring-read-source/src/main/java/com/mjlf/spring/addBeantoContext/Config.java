package com.mjlf.spring.addBeantoContext;

import com.mjlf.spring.addBeantoContext.annotation.CustomQualifiter;
import com.mjlf.spring.addBeantoContext.condition.MjlfCondition;
import com.mjlf.spring.addBeantoContext.config.ImportConfig;
import org.springframework.beans.factory.annotation.CustomAutowireConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import java.util.Collections;

/**
 * @ClassName Config
 * @Author mjlft
 * @Date 2019/12/20 18:50
 * @Version 1.0
 * @Description TODO
 */
@Configuration
@ImportResource("classpath:application.xml")
@ComponentScan(basePackages = "com.mjlf.spring.addBeantoContext", basePackageClasses = Config.class)
@Conditional(MjlfCondition.class)
@Import(ImportConfig.class)
@PropertySource("classpath:pro.properties")
public class Config {

	@Value("${orgtest}")
	private String name;
}
