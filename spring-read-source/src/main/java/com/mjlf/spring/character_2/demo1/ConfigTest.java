package com.mjlf.spring.character_2.demo1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ClassName ConfigTest
 * @Author mjlft
 * @Date 2019/12/18 18:26
 * @Version 1.0
 * @Description 测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
public class ConfigTest {
	@Autowired
	private CD cd;

	@Test
	public void tC(){
		cd.play();
	}
}