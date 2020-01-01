package com.mjlf.spring.character_2.demo1;

import org.springframework.stereotype.Component;

/**
 * @ClassName MusicCD
 * @Author mjlft
 * @Date 2019/12/18 18:23
 * @Version 1.0
 * @Description 音乐CD, 会自动注入
 */
@Component
public class MusicCD implements CD {
	@Override
	public void play() {
		System.out.println("播放音乐");
	}
}
