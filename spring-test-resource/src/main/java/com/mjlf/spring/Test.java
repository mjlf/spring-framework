package com.mjlf.spring;

import com.mjlf.spring.config.Config;
import com.mjlf.spring.config.TestConfig;
import com.mjlf.spring.entity.UserDao;
import com.mjlf.spring.entity.UserDao1;
import com.mjlf.spring.process.UserDaoApplicationAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName Test
 * @Author mjlft
 * @Date 2019/7/5 0:30
 * @Version 1.0
 * @Description TODO
 */
public class Test {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(Config.class);
		UserDao1 userDao = applicationContext.getBean(UserDao1.class);
		userDao.showName();
		userDao.showTestProperties();

		System.out.println("------------------------applicationAware-----------------------------------");
		UserDaoApplicationAware applicationAware = applicationContext.getBean(UserDaoApplicationAware.class);
		UserDao ud = applicationAware.testGetUserDao();
		ud.showName();

//		applicationContext.register(TestConfig.class);
//		applicationContext.refresh();
//		TestConfig testConfig = applicationContext.getBean(TestConfig.class);
	}
}
