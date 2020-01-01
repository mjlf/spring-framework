package com.mjlf.spring.character_2.demo1;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName Config
 * @Author mjlft
 * @Date 2019/12/18 18:24
 * @Version 1.0
 * @Description Spring java 配置类
 */
//标准为配置类
@Configuration

//进行自动扫描
@ComponentScan(basePackages = "com.mjlf.spring")
public class Config {
}
