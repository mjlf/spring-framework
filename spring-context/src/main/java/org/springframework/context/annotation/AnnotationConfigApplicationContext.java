/*
 * Copyright 2002-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.context.annotation;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionCustomizer;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;

/**
 * Standalone application context, accepting annotated classes as input - in particular
 * {@link Configuration @Configuration}-annotated classes, but also plain
 * {@link org.springframework.stereotype.Component @Component} types and JSR-330 compliant
 * classes using {@code javax.inject} annotations. Allows for registering classes one by
 * one using {@link #register(Class...)} as well as for classpath scanning using
 * {@link #scan(String...)}.
 *
 * <p>In case of multiple {@code @Configuration} classes, @{@link Bean} methods defined in
 * later classes will override those defined in earlier classes. This can be leveraged to
 * deliberately override certain bean definitions via an extra {@code @Configuration}
 * class.
 *
 * <p>See @{@link Configuration}'s javadoc for usage examples.
 *
 * @author Juergen Hoeller
 * @author Chris Beams
 * @since 3.0
 * @see #register
 * @see #scan
 * @see AnnotatedBeanDefinitionReader
 * @see ClassPathBeanDefinitionScanner
 * @see org.springframework.context.support.GenericXmlApplicationContext
 */
public class AnnotationConfigApplicationContext extends GenericApplicationContext implements AnnotationConfigRegistry {

	private final AnnotatedBeanDefinitionReader reader;

	private final ClassPathBeanDefinitionScanner scanner;


	/**
	 * Create a new AnnotationConfigApplicationContext that needs to be populated
	 * through {@link #register} calls and then manually {@linkplain #refresh refreshed}.
	 */
	public AnnotationConfigApplicationContext() {
		/**
		 * 创建一个BeanDefinitionReader(一个beanDefinition 阅读器)
		 * 这创建的同时给BeanFactory设置了一个注解排序比较器
		 * 同时设置了一个转换器， 还设置了5个spring内部的beanDefinition
		 * AutowiredAnnotationBeanPostProcessor
		 * ConfigurationClassPostProcessor
		 * CommonAnnotationBeanPostProcessor
		 * PersistenceAnnotationBeanPostProcessor
		 * DefaultEventListenerFactory
		 */
		this.reader = new AnnotatedBeanDefinitionReader(this);

		/**
		 *	创建一个BeanDefinition扫描器， 这个扫描器可以扫描指定包下那些需要被转换为BeanDefinition的类，具体怎么做了？？？
		 *	主要扫描带有
		 * {@link org.springframework.stereotype.Component @Component},
		 * {@link org.springframework.stereotype.Repository @Repository},
		 * {@link org.springframework.stereotype.Service @Service}, or
		 * {@link org.springframework.stereotype.Controller @Controller} stereotype.
		 * 注解的类
		 *  标有注解@Component注解，及其子注解都会被扫描
		 *
		 *  初始化的时候不负责扫描， 如果需要扫描用户在初始化后添加进去后的包， 使用这个对象
		 *  spring 在启动时内部自己创建了一个新的scaner, 代码在什么地方？？？
		 */
		this.scanner = new ClassPathBeanDefinitionScanner(this);
	}

	/**
	 * Create a new AnnotationConfigApplicationContext with the given DefaultListableBeanFactory.
	 * @param beanFactory the DefaultListableBeanFactory instance to use for this context
	 */
	public AnnotationConfigApplicationContext(DefaultListableBeanFactory beanFactory) {
		super(beanFactory);
		this.reader = new AnnotatedBeanDefinitionReader(this);
		this.scanner = new ClassPathBeanDefinitionScanner(this);
	}

	/**
	 * Create a new AnnotationConfigApplicationContext, deriving bean definitions
	 * from the given annotated classes and automatically refreshing the context.
	 * @param annotatedClasses one or more annotated classes,
	 * e.g. {@link Configuration @Configuration} classes
	 */
	public AnnotationConfigApplicationContext(Class<?>... annotatedClasses) {
		//首先调用父类的构造方法GenericApplicationContext(),
		// 这个类继承了AbstractApplicationContext同时实现了BeanDefinitionRegistry
		//同时在调用父类构造方法的时候实现实例化了beanFactory[DefaultListableBeanFactory()]
		//实例化AnnotatedBeanDefinitionReader： 将class 转换为BeanDefinition
		//实例化ClassPathBeanDefinitionScanner：扫描包下边的类， 并将这些需要转换的类转换为BeanDefinition
		//beanDefinition 是spring中对Bean对象的定义， 就像类和对象一样， beanFactory是构建beanDefinition的
		//工具， 这个工具非常庞大并且复杂， 整个applicationContext就是一个注册器，它管理者所有bean的创建消除，以及
		//其他事项，用户也可以通过它提供的拓展接口进行拓展操作

		/**
		 * 调用父类的构造方法， 主要添加reader[AnnotationBeanDefinitionReader] 和 scanner[ClassPathBeanDefinitionScanner]
		 * 两个属性
		 *
		 * reader 主要负责将class 转换为 BeanDefinition,在实例化reader的过程添加了
		 * 1. Condition 判定器， 用于判断@Conditional 注解
		 * 2. 添加了DependencyComparator 比较器， 主要用于处理@Order注解排序
		 * 3. 设置了AutowireCandidateResolver， 处理像@Lazy这样的注解
		 * 4. 添加了5个spring root BeanDefinition
		 *  	 * AutowiredAnnotationBeanPostProcessor
		 * 		 * ConfigurationClassPostProcessor[很重要]
		 * 		 * CommonAnnotationBeanPostProcessor
		 * 		 * PersistenceAnnotationBeanPostProcessor
		 * 		 * DefaultEventListenerFactory
		 *
		 * scanner: 用于扫描classpath路径下的类， 如果使用默认过滤扫描将会扫描待用如下注解的类， 否则用户需要自定一IncludeFilter
		 * 		 * {@link org.springframework.stereotype.Component @Component},
		 * 		 * {@link org.springframework.stereotype.Repository @Repository},
		 * 		 * {@link org.springframework.stereotype.Service @Service}, or
		 * 		 * {@link org.springframework.stereotype.Controller @Controller} stereotype.
		 * 		 * 注解的类
		 * 		 *  标有注解@Component注解，及其子注解都会被扫描
		 *
		 * 		 但是实际上在启动过程中， 内部并没有使用在此实例化的这个scanner, 而是在后续创建了一个新的， 至于为啥， ？？？不知道，
		 * 		 这里的这个有啥用， 后续说明
		 */
		this();

		//执行注册,这里注册的是什么
		//将构造方法传入的annotatedClasses转换为BeanDefinition保存到Factory中的Map里
		/**
		 * 这里的注册实际上是将传入的annotatedClasses转换为BeanDefinition存储到Factory的map中
		 * 而且内部实际调用的时候在构造函数中实例化的reader对象的register()方法，但是在内部实际调用了registerBean()方法
		 * 再到doRegisterBean()方法
		 *
		 * 根据注释：要求传入的类是带有注解的， 并且这些类不能重复的被添加到Map中
		 * 处理类上的一些普通注解， 将这些注解的值进行除了转换设置到BeanDefinition中， 像
		 * @Lazy
		 * @Primary
		 * @DependensOn
		 * @Role
		 * @Description
		 *
		 * 最后判断创建一个AnnotatedGenericBeanDefinition 对象， 然后判断是需要做代理处理， 如果需要代理，
		 * 需要做更多的操作，
		 * 设置 beanDefinition 的名字， 如果注解中提供Value属性， 则使用Value做为名称， 但是如果多个注解
		 * 同时带有Value属性， 那么这些value属性必须一致， 否则将会抛出异常
		 * 如果所有的注解都没有带有Value属性， 那么使用类的简单名称作为beanDefinition名称
		 */
		register(annotatedClasses);

		//执行刷新， 注册单个类的时候不需要调用?但是实际测试依旧需要
		//初始化Spring环境， 包括进行包扫描， 将beanDefinition 进行实例化， 后置处理器的处理等等，
		//这个方法超级重要
		refresh();
	}

	/**
	 * Create a new AnnotationConfigApplicationContext, scanning for bean definitions
	 * in the given packages and automatically refreshing the context.
	 * @param basePackages the packages to check for annotated classes
	 */
	public AnnotationConfigApplicationContext(String... basePackages) {
		this();
		scan(basePackages);
		refresh();
	}


	/**
	 * Propagates the given custom {@code Environment} to the underlying
	 * {@link AnnotatedBeanDefinitionReader} and {@link ClassPathBeanDefinitionScanner}.
	 */
	@Override
	public void setEnvironment(ConfigurableEnvironment environment) {
		super.setEnvironment(environment);
		this.reader.setEnvironment(environment);
		this.scanner.setEnvironment(environment);
	}

	/**
	 * Provide a custom {@link BeanNameGenerator} for use with {@link AnnotatedBeanDefinitionReader}
	 * and/or {@link ClassPathBeanDefinitionScanner}, if any.
	 * <p>Default is {@link org.springframework.context.annotation.AnnotationBeanNameGenerator}.
	 * <p>Any call to this method must occur prior to calls to {@link #register(Class...)}
	 * and/or {@link #scan(String...)}.
	 * @see AnnotatedBeanDefinitionReader#setBeanNameGenerator
	 * @see ClassPathBeanDefinitionScanner#setBeanNameGenerator
	 */
	public void setBeanNameGenerator(BeanNameGenerator beanNameGenerator) {
		this.reader.setBeanNameGenerator(beanNameGenerator);
		this.scanner.setBeanNameGenerator(beanNameGenerator);
		getBeanFactory().registerSingleton(
				AnnotationConfigUtils.CONFIGURATION_BEAN_NAME_GENERATOR, beanNameGenerator);
	}

	/**
	 * Set the {@link ScopeMetadataResolver} to use for detected bean classes.
	 * <p>The default is an {@link AnnotationScopeMetadataResolver}.
	 * <p>Any call to this method must occur prior to calls to {@link #register(Class...)}
	 * and/or {@link #scan(String...)}.
	 */
	public void setScopeMetadataResolver(ScopeMetadataResolver scopeMetadataResolver) {
		this.reader.setScopeMetadataResolver(scopeMetadataResolver);
		this.scanner.setScopeMetadataResolver(scopeMetadataResolver);
	}


	//---------------------------------------------------------------------
	// Implementation of AnnotationConfigRegistry
	//---------------------------------------------------------------------

	/**
	 * Register one or more annotated classes to be processed.
	 * <p>Note that {@link #refresh()} must be called in order for the context
	 * to fully process the new classes.
	 * @param annotatedClasses one or more annotated classes,
	 * e.g. {@link Configuration @Configuration} classes
	 * @see #scan(String...)
	 * @see #refresh()
	 *
	 * 注册一个或多个被注解的类到Spring,
	 * 需要注意的是， 执行register方法后必须执行refresh方法进行刷新
	 *
	 */
	public void register(Class<?>... annotatedClasses) {
		Assert.notEmpty(annotatedClasses, "At least one annotated class must be specified");
		this.reader.register(annotatedClasses);
	}

	/**
	 * Perform a scan within the specified base packages.
	 * <p>Note that {@link #refresh()} must be called in order for the context
	 * to fully process the new classes.
	 * @param basePackages the packages to check for annotated classes
	 * @see #register(Class...)
	 * @see #refresh()
	 */
	public void scan(String... basePackages) {
		Assert.notEmpty(basePackages, "At least one base package must be specified");
		this.scanner.scan(basePackages);
	}


	//---------------------------------------------------------------------
	// Adapt superclass registerBean calls to AnnotatedBeanDefinitionReader
	//---------------------------------------------------------------------

	@Override
	public <T> void registerBean(@Nullable String beanName, Class<T> beanClass,
			@Nullable Supplier<T> supplier, BeanDefinitionCustomizer... customizers) {

		this.reader.registerBean(beanClass, beanName, supplier, customizers);
	}

}
