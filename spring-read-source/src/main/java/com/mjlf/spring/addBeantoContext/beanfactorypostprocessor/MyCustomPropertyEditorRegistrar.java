package com.mjlf.spring.addBeantoContext.beanfactorypostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName MyCustomPropertyEditorRegistrar
 * @Author mjlft
 * @Date 2019/12/26 9:54
 * @Version 1.0
 * @Description Spring 自定义属性编辑器后置处理器
 * 这个类主要是负责将自定义属性编辑器注册到Spring中，使spring得以识别
 * 默认Spring 提供了这个类做为后置处理器，如果我们使用xml配置的方式，
 * 可以使用属性注入的方式将自定义的PropertyEditorRegistry属性，但是
 * 我们使用注解方式就之后继承这个类了
 */
@Component
public class MyCustomPropertyEditorRegistrar extends CustomEditorConfigurer {


	PropertyEditorRegistrar propertyEditorRegistrar = new PropertyEditorRegistrar() {
		@Override
		public void registerCustomEditors(PropertyEditorRegistry registry) {
			registry.registerCustomEditor(Date.class, new PropertyEditorSupport(){
				@Override
				public String getAsText() {
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
					Date date = (Date) getValue();
					return simpleDateFormat.format(date);
				}

				@Override
				public void setAsText(String text) throws IllegalArgumentException {
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
					Date date = null;
					try{
						date = simpleDateFormat.parse(text);
					}catch (Exception e){
						e.printStackTrace();
					}
					setValue(date);
				}
			});
		}
	};

	/**
	 * PropertyEditorRegistrar 是一个自定义属性编辑器注入接口，通过这个接口可以将我们自定的
	 * PropertyEditor注入到spring,者需要我们自己实现
	 * 这里提供一个setter方法是使用策略模式
	 * 也是使用不同的实现，我们可以得到不同的效果，也就是使用不同的策略，得到不同的反向
	 * @param propertyEditorRegistrar
	 */
	public void setPropertyEditorRegistrar(PropertyEditorRegistrar propertyEditorRegistrar) {
		this.propertyEditorRegistrar = propertyEditorRegistrar;
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		super.setPropertyEditorRegistrars(new PropertyEditorRegistrar[]{propertyEditorRegistrar});
		super.postProcessBeanFactory(beanFactory);
	}
}
