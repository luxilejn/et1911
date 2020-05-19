package com.etoak.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/hello")
public class HelloController {

	/**
	 * http://ip:port/contextPath/hello/index
	 */
	@RequestMapping("/index")
	public String index(HttpServletRequest request) {
		// 获取前端请求参数
		String name = request.getParameter("name");
		System.out.println("param name - " + name);
		
		// 向request域传值
		request.setAttribute("result", "Hello " + name);
		
		// prefix + hello/index + suffix
		return "hello/index";
	}
	
	
	
	
	
	
}
