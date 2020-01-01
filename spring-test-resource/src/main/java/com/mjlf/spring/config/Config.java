package com.mjlf.spring.config;

import com.mjlf.spring.condition.MyCondition;
import com.mjlf.spring.processer.MyProcess;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

/**
 * @ClassName Config
 * @Author mjlft
 * @Date 2019/7/5 0:30
 * @Version 1.0
 * @Description TODO
 */
@Configuration("lalal")
@ComponentScan("com.mjlf")
@Import(MyProcess.class)
@Qualifier
//@Conditional(MyCondition.class)
@Scope(proxyMode = ScopedProxyMode.DEFAULT)
@PropertySource("prop.properties")
public class Config {

	@Bean
	public String gbean(){
		return new String("hello");
	}


	/**
	 * 通过PropertySourcesPlaceholderConfigurer属性占位符配置类配置添加配置文件
	 * @return
	 */
	@Bean
	public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
		PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();

		propertySourcesPlaceholderConfigurer
				.setLocation(new ClassPathResource("override.properties"));
		return propertySourcesPlaceholderConfigurer;
	}
}
