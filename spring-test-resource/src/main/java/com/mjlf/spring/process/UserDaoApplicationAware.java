package com.mjlf.spring.process;

import com.mjlf.spring.entity.UserDao;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @ClassName UserDaoBeanProcess
 * @Author mjlft
 * @Date 2019/7/6 10:20
 * @Version 1.0
 * @Description ApplicationContextAware 通过这个接口可以在类内部维护一个ApplicationContext,
 * 如果在程序内部需要用到ApplicationContext, 这个接口将会非常有用
 */
@Component
public class UserDaoApplicationAware implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	public UserDao testGetUserDao(){
		return this.applicationContext.getBean(UserDao.class);
	}
}
