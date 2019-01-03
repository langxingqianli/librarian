package com.zhaolongefu.librarian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * 图书管理平台启动类
 * @author maiLang
 * @since 2018-12-28
 * @version 0.0.1-SNAPSHOT
 */
@ComponentScan
@EnableAutoConfiguration
public class UserApplication {
	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}
}
