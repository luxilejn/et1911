package com.etoak;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mian {

	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("spring-activemq.xml");
	}

}
